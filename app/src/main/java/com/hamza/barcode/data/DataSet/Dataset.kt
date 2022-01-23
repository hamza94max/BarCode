package com.hamza.barcode.data.DataSet

import com.hamza.barcode.data.Models.BarCodeContent

class Dataset {

    companion object {

        private val list = ArrayList<BarCodeContent>()

        fun SearchforBarcode(otherBarcodeId: String): BarCodeContent? {

            getAllData()

            var barCodeContent: BarCodeContent? = null

            for (i in 0..list.size) {
                if (otherBarcodeId.equals(list[i].barcodeID))
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
                    56

                )
            )
            list.add(
                BarCodeContent(
                    2,
                    "222 68749",
                    "adcddd",
                    ItemType.Food.toString(),
                    "2022/11/20",
                    25

                )
            )
            list.add(
                BarCodeContent(
                    3,
                    "222 68749",
                    "Comtrex",
                    ItemType.Food.toString(),
                    "2020/5/16",
                    14

                )
            )
            list.add(
                BarCodeContent(
                    4,
                    "222 68749",
                    "Comtrex",
                    ItemType.Food.toString(),
                    "2022/5/16",
                    25

                )
            )
            list.add(
                BarCodeContent(
                    5,
                    "222 68749",
                    "Comtrex",
                    ItemType.Food.toString(),
                    "2022/5/16",
                    36

                )
            )
            list.add(
                BarCodeContent(
                    6,
                    "222 68749",
                    "Comtrex",
                    ItemType.Food.toString(),
                    "2022/5/16",
                    25

                )
            )
            list.add(
                BarCodeContent(
                    7,
                    "222 68749",
                    "Comtrex",
                    ItemType.Food.toString(),
                    "2022/5/16",
                    18

                )
            )
            list.add(
                BarCodeContent(
                    8,
                    "222 68749",
                    "Comtrex",
                    ItemType.Food.toString(),
                    "2022/5/16",
                    3
                )
            )

            return list
        }


    }


}