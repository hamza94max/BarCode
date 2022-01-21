package com.hamza.barcode.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BarCodeContents")
data class BarCodeContent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "itemName")
    val itemName: String,
    @ColumnInfo(name = "itemType")
    val itemtype: String,
    @ColumnInfo(name = "ExpireDate")
    val ExpireDate: String,

    //val lastedDays : Int


)
