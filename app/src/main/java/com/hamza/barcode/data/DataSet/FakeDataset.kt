package com.hamza.barcode.data.DataSet

import com.hamza.barcode.data.Models.BarCodeItem
import com.hamza.barcode.data.Models.ItemType
import kotlin.random.Random

object FakeDataset {

    private val list = ArrayList<BarCodeItem>()

    /**
     * We are here searching for the result from Barcode screen in data base
     * which we created
     */
    fun searchForBarcode(otherBarcodeId: String): BarCodeItem? {

        getAllData()

        var barCodeItem: BarCodeItem? = null

        for (i in 0 until list.size - 1) {
            if (otherBarcodeId.equals(list[i].barcodeID))
                barCodeItem = list[i]
        }
        return barCodeItem
        }


    /**
     * @return a list of barcodeContent model as dataBase and we search for item using barcode result Id
     */
    private fun getAllData(): ArrayList<BarCodeItem> {

        list.add(
            BarCodeItem(
                Random.nextInt(),
                "6223001874294",
                "Ferrero Nutella - 400 g",
                ItemType.Chocolates.toString(),
                "16/5/2022",
                56

            )
            )
            list.add(
                BarCodeItem(
                    Random.nextInt(),
                    "222 68749",
                    "Spring water",
                    ItemType.Drinks.toString(),
                    "20/11/2022",
                    25

                )
            )
            list.add(
                BarCodeItem(
                    Random.nextInt(),
                    "089686120660",
                    "Indomie",
                    ItemType.Food.toString(),
                    "27/12/2021",
                    14

                )
            )
            list.add(
                BarCodeItem(
                    Random.nextInt(),
                    "6223001360766",
                    "Pepsi ",
                    ItemType.Drinks.toString(),
                    "16/5/2022",
                    25

                )
            )
            list.add(
                BarCodeItem(
                    Random.nextInt(),
                    "6223000430040",
                    "Bread",
                    ItemType.Food.toString(),
                    "16/2/2022",
                    36

                )
            )
            list.add(
                BarCodeItem(
                    Random.nextInt(),
                    "6223001878001",
                    "Milk - Almarai",
                    ItemType.Drinks.toString(),
                    "2021/12/26",
                    25

                )
            )
            list.add(
                BarCodeItem(
                    Random.nextInt(),
                    "6221032490304",
                    "Biscuits 300gm ",
                    ItemType.Snacks.toString(),
                    "1/26/2022",
                    18

                )
            )
            list.add(
                BarCodeItem(
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
