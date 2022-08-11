package com.hamza.barcode.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hamza.barcode.Utils.Util
import com.hamza.barcode.data.DataSet.FakeDataset
import com.hamza.barcode.databinding.ActivityMainBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewmodel by viewModels<BarcodeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun newBarcode(view: View) {
        Toast.makeText(applicationContext, "Cancelled", Toast.LENGTH_LONG).show()
    }

    private val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->

        val context: Context = this
        if (result.contents == null) {
            Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            val newBarcode = FakeDataset.searchForBarcode(result.contents)

            if (newBarcode != null) {

                newBarcode.expiredDays =
                    Util.getExpiredDaysforItem(newBarcode.expireDate)

                Toast.makeText(
                    context,
                    "added : " + newBarcode.itemName,
                    Toast.LENGTH_SHORT
                ).show()

                newBarcode.let { viewmodel.insertItem(it) }
            } else {
                Toast.makeText(context, "Not found in dataBase ! ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

