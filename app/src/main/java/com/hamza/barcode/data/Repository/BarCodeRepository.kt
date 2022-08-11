package com.hamza.barcode.data.Repository

import android.app.Application
import com.hamza.barcode.Utils.Util
import com.hamza.barcode.data.Dao.BarCodeDao
import com.hamza.barcode.data.DataBase.BarcodeDataBase.Companion.getInstance
import com.hamza.barcode.data.Models.BarCodeItem

class BarCodeRepository(application: Application?) {

    private val dao: BarCodeDao by lazy {
        val database = getInstance(application!!)
        database.getBarCodeDao()
    }

    fun getAllNonExpiredItems() = dao.getNonexpiredItems()

    fun getAllExpiredItems() = dao.getexpiredItems()

    suspend fun insertItem(barCodeItem: BarCodeItem) {
        barCodeItem.expiredDays = Util.getExpiredDaysforItem(barCodeItem.expireDate)
        dao.insertItem(barCodeItem)
    }

    suspend fun deleteAllItem() {
        dao.deleteAllItems()
    }
}