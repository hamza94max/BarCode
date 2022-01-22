package com.hamza.barcode.DataSet

import com.hamza.barcode.Models.BarCodeContent

class Dataset {

    private val list = ArrayList<BarCodeContent>()

    fun SearchforBarcode(otherBarcode: BarCodeContent): BarCodeContent? {

        getAllData()

        var barCodeContent: BarCodeContent? = null

        for (i in 0..list.size) {
            if (otherBarcode.barcodeID.equals(list[i].barcodeID))
                barCodeContent = list[i]
        }
        return barCodeContent
    }


    private fun getAllData(): ArrayList<BarCodeContent> {


        list.add(
            BarCodeContent(
                1,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2022/5/16",
                false
            )
        )
        list.add(
            BarCodeContent(
                2,
                "222 68749",
                "adcddd",
                ItemType.Food.toString(),
                "2022/11/20",
                false
            )
        )
        list.add(
            BarCodeContent(
                3,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2020/5/16",
                true
            )
        )
        list.add(
            BarCodeContent(
                4,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2022/5/16",
                false
            )
        )
        list.add(
            BarCodeContent(
                5,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2022/5/16",
                false
            )
        )
        list.add(
            BarCodeContent(
                6,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2022/5/16",
                false
            )
        )
        list.add(
            BarCodeContent(
                7,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2022/5/16",
                false
            )
        )
        list.add(
            BarCodeContent(
                8,
                "222 68749",
                "Comtrex",
                ItemType.Food.toString(),
                "2022/5/16",
                false
            )
        )

        return list
    }


}