package com.hamza.barcode.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.barcode.Models.BarCodeContent
import com.hamza.barcode.Repository.BarCodeRepository
import kotlinx.coroutines.launch


class BarcodeViewmodel(application: Application) : AndroidViewModel(application) {

    private val repository: BarCodeRepository = BarCodeRepository(application)
    val getItems by lazy { repository.AllItems() }


    fun insertItem(barCodeContent: BarCodeContent) {
        viewModelScope.launch {
            repository.insertItem(barCodeContent)
        }
    }

}
