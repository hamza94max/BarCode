package com.hamza.barcode.data.DataSet

import com.hamza.barcode.data.Models.BarCodeContent
import kotlin.random.Random

class Dataset {

    companion object {

        private val list = ArrayList<BarCodeContent>()


        /**
         * We are here searching for the result from Barcode screen in data base
         * which we created
         */
        fun SearchforBarcode(otherBarcodeId: String): BarCodeContent? {

            getAllData()

            var barCodeContent: BarCodeContent? = null

            for (i in 0 until list.size - 1) {
                if (otherBarcodeId.equals(list[i].barcodeID))
                    barCodeContent = list[i]
            }
            return barCodeContent
        }


        /**
         * @return a list of barcodeContent model as dataBase and we search for item using barcode result Id
         */
        private fun getAllData(): ArrayList<BarCodeContent> {

            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "6223001874294",
                    "Ferrero Nutella - 400 g",
                    ItemType.Chocolates.toString(),
                    "16/5/2022",
                    56

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "222 68749",
                    "Spring water",
                    ItemType.Drinks.toString(),
                    "20/11/2022",
                    25

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "089686120660",
                    "Indomie",
                    ItemType.Food.toString(),
                    "16/5/2020",
                    14

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "6223001360766",
                    "Pepsi ",
                    ItemType.Drinks.toString(),
                    "16/5/2022",
                    25

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "6223000430040",
                    "Bread",
                    ItemType.Food.toString(),
                    "16/2/2022",
                    36

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "6223001878001",
                    "Milk - Almarai",
                    ItemType.Drinks.toString(),
                    "2021/12/26",
                    25

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "6221032490304",
                    "Biscuits 300gm ",
                    ItemType.Snacks.toString(),
                    "1/26/2022",
                    18

                )
            )
            list.add(
                BarCodeContent(
                    Random.nextInt(),
                    "6221031490309",
                    "Doritos",
                    ItemType.Snacks.toString(),
                    "16/5/2020",
                    3
                )
            )
            return list
        }
    }
}