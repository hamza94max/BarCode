package com.hamza.barcode.DataSet

enum class ItemType {

    Food, Drinks;


    override fun toString(): String {
        return when (this) {
            Food -> "Food"
            Drinks -> "Drinks"


        }
    }
}