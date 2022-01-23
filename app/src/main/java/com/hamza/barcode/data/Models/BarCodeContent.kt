package com.hamza.barcode.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Here is the table we created to store values in it
 */

@Entity(tableName = "BarCodetable")
data class BarCodeContent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "barcodeID")
    val barcodeID: String,
    @ColumnInfo(name = "itemName")
    val itemName: String,
    @ColumnInfo(name = "itemType")
    val itemtype: String,
    @ColumnInfo(name = "ExpireDate")
    val ExpireDate: String,

    @ColumnInfo(name = "expiredDays")
    var expiredDays: Int


)
