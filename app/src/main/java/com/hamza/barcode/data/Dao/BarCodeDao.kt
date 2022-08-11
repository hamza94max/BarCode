package com.hamza.barcode.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hamza.barcode.data.Models.BarCodeItem

@Dao
interface BarCodeDao {

    @Insert
    suspend fun insertItem(barCodeItem: BarCodeItem)

    @Query("SELECT * FROM BarCodeItems where expiredDays > 0 order by expiredDays  ")
    fun getNonexpiredItems(): LiveData<List<BarCodeItem>>

    @Query("SELECT * FROM BarCodeItems where expiredDays < 0 order by expiredDays  ")
    fun getexpiredItems(): LiveData<List<BarCodeItem>>

    @Delete
    suspend fun deleteItem(barCodeItem: BarCodeItem?)

    @Query("DELETE FROM BarCodeItems")
    suspend fun deleteAllItems()
}