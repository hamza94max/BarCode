package com.hamza.barcode.data.Repository

import android.app.Application
import com.hamza.barcode.data.Dao.BarCodeDao
import com.hamza.barcode.data.DataBase.BarcodeDataBase.Companion.getInstance
import com.hamza.barcode.data.DataSet.Util
import com.hamza.barcode.data.Models.BarCodeContent


class BarCodeRepository(application: Application?) {

    private val dao: BarCodeDao by lazy {
        val database = getInstance(application!!)
        database.getBarCodeDao()
    }

    fun AllNonexpiredItems() = dao.getNonexpiredItems()

    fun AllexpiredItems() = dao.getexpiredItems()


    suspend fun insertItem(barCodeContent: BarCodeContent) {
        barCodeContent.expiredDays = Util.getexpiredDaysforItem(barCodeContent.ExpireDate)
        dao.insertItem(barCodeContent)
    }

    suspend fun deleteItem() {
        dao.deleteAllItems()
    }
}