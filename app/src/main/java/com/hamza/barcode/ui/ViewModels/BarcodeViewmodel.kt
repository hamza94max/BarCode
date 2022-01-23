package com.hamza.barcode.ui.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.barcode.data.Models.BarCodeContent
import com.hamza.barcode.data.Repository.BarCodeRepository
import kotlinx.coroutines.launch


class BarcodeViewmodel(application: Application) : AndroidViewModel(application) {

    private val repository: BarCodeRepository = BarCodeRepository(application)

    val getNonexpiredItems by lazy { repository.AllNonexpiredItems() }
    val getexpiredItems by lazy { repository.AllexpiredItems() }

    fun insertItem(barCodeContent: BarCodeContent) {
        viewModelScope.launch {
            repository.insertItem(barCodeContent)
        }
    }

}
