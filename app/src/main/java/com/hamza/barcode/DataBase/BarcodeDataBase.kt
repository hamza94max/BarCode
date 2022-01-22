package com.hamza.barcode.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hamza.barcode.Dao.BarCodeDao
import com.hamza.barcode.Models.BarCodeContent

@Database(entities = [BarCodeContent::class], version = 1)

abstract class BarcodeDataBase : RoomDatabase() {

    abstract fun getBarCodeDao(): BarCodeDao

    companion object {
        @Volatile
        private var instance: BarcodeDataBase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BarcodeDataBase::class.java,
                "barCode_db"
            ).fallbackToDestructiveMigration()
                .build()
    }

}