package com.hamza.barcode.data.DataSet

enum class ItemType {

    Food, Drinks, Chocolates, Snacks, ;

    /**
     * enum class to avoid String Url
     * here is an article I wrote about this subject
     * // https://dev.to/hamza94max/use-enum-class-to-avoid-string-errors-pm8
     */
    override fun toString(): String {
        return when (this) {
            Food -> "Food"
            Drinks -> "Drinks"
            Chocolates -> "Chocolates"
            Snacks -> "Snacks"

        }
    }
}