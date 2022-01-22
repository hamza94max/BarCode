package com.hamza.barcode.Repository

import android.app.Application
import com.hamza.barcode.Dao.BarCodeDao
import com.hamza.barcode.DataBase.BarcodeDataBase.Companion.getInstance
import com.hamza.barcode.Models.BarCodeContent


class BarCodeRepository(application: Application?) {

    private val dao: BarCodeDao by lazy {
        val database = getInstance(application!!)
        database.getBarCodeDao()
    }

    fun AllItems() = dao.getAllItems()

    suspend fun insertItem(barCodeContent: BarCodeContent) {
        dao.insertItem(barCodeContent)
    }

    suspend fun deleteItem(barCodeContent: BarCodeContent) {
        dao.deleteItem(barCodeContent)
    }
}