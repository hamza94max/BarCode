package com.hamza.barcode.data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BarCodeItems")
data class BarCodeItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "barcodeID")
    val barcodeID: String,
    @ColumnInfo(name = "itemName")
    val itemName: String,
    @ColumnInfo(name = "itemType")
    val itemtype: String,
    @ColumnInfo(name = "ExpireDate")
    val expireDate: String,

    @ColumnInfo(name = "expiredDays")
    var expiredDays: Int
) {
    constructor(
        barcodeID: String,
        itemName: String,
        itemtype: String,
        expireDate: String,
        expiredDays: Int
    ) :
            this(0, barcodeID, itemName, itemtype, expireDate, expiredDays)
}
