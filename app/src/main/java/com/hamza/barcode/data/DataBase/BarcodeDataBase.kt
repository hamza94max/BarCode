package com.hamza.barcode.data.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hamza.barcode.data.Dao.BarCodeDao
import com.hamza.barcode.data.Models.BarCodeItem
import com.hamza.barcode.data.Models.ItemType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@Database(
    entities = [BarCodeItem::class],
    version = 3
)
abstract class BarcodeDataBase : RoomDatabase() {

    abstract fun getBarCodeDao(): BarCodeDao

    companion object {
        @Volatile
        private var instance: BarcodeDataBase? = null
        private val scope: CoroutineScope? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BarcodeDataBase::class.java,
                "barCode_db"
            ).fallbackToDestructiveMigration()
                //.addCallback(BarcodeDatabaseCallback(scope!!))
                .build()


    }

    private class BarcodeDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let { database ->
                scope.launch {
                    populateDatabase(database.getBarCodeDao())
                }
            }
        }

        suspend fun populateDatabase(BarCodeDao: BarCodeDao) {
            BarCodeDao.deleteAllItems()

            val barcode1 = BarCodeItem(
                Random.nextInt(),
                "6223001874294",
                "Ferrero Nutella - 400 g",
                ItemType.Chocolates.toString(),
                "16/5/2022",
                56

            )
            val barcode2 = BarCodeItem(
                Random.nextInt(),
                "6223001360766",
                "Pepsi ",
                ItemType.Drinks.toString(),
                "16/5/2022",
                25

            )
            val barcode3 = BarCodeItem(
                Random.nextInt(),
                "6223001878001",
                "Milk - Almarai",
                ItemType.Drinks.toString(),
                "2021/12/26",
                25

            )

            val barcode4 = BarCodeItem(
                Random.nextInt(),
                "6221032490304",
                "Biscuits 300gm ",
                ItemType.Snacks.toString(),
                "1/26/2022",
                18
            )

            BarCodeDao.insertItem(barcode1)
            BarCodeDao.insertItem(barcode2)
            BarCodeDao.insertItem(barcode3)
            BarCodeDao.insertItem(barcode4)

        }
    }
}