package com.hamza.barcode.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hamza.barcode.data.Models.BarCodeContent


@Dao
abstract class BarCodeDao {

    @Insert
    abstract suspend fun insertItem(barCodeContent: BarCodeContent)

    @Query("SELECT * FROM BarCodetable where expiredDays > 0 order by expiredDays  ")
    abstract fun getNonexpiredItems(): LiveData<List<BarCodeContent>>

    @Query("SELECT * FROM BarCodetable where expiredDays < 0 order by expiredDays  ")
    abstract fun getexpiredItems(): LiveData<List<BarCodeContent>>

    @Delete
    abstract suspend fun deleteItem(barCodeContent: BarCodeContent?)

    @Query("DELETE FROM BarCodetable")
    abstract suspend fun deleteAllItems()
}