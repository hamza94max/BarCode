package com.hamza.barcode.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hamza.barcode.Models.BarCodeContent


@Dao
abstract class BarCodeDao {

    @Insert
    abstract suspend fun insertItem(barCodeContent: BarCodeContent)

    @Query("SELECT * FROM BarCodeContents")
    abstract suspend fun getAllItems(): LiveData<List<BarCodeContent?>?>?

    @Delete
    abstract suspend fun deleteItem(barCodeContent: BarCodeContent?)

    @Query("DELETE FROM BarCodeContents")
    abstract suspend fun deleteAllItems()
}