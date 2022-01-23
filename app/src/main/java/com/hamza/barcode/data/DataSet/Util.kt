package com.hamza.barcode.data.DataSet

import android.annotation.SuppressLint
import android.os.Build
import java.text.SimpleDateFormat
import java.util.*

class Util {

    companion object {


        /**
         * here we calculated the days untill the product is expired
         */


        @SuppressLint("SimpleDateFormat")
        fun getExpiredDaysforItem(expiredate: String): Int {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val expireDate: Date = sdf.parse(expiredate)

            val diff: Long = Date().time - expireDate.time
            val seconds = diff / 1000
            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24

            if (isExpired(expiredate))
                return -days.toInt()

            return days.toInt()
        }

        @SuppressLint("SimpleDateFormat")
        private fun isExpired(expiredDate: String): Boolean {

            var isExpired = false

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                val strDate: Date = sdf.parse(expiredDate)
                isExpired = Date().after(strDate)
            }
            return !isExpired
        }

    }


}