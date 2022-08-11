package com.hamza.barcode.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.hamza.barcode.Workmanger.NotificationWorker
import com.hamza.barcode.data.Models.BarCodeItem
import com.hamza.barcode.data.Repository.BarCodeRepository
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class BarcodeViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(this.getApplication())

    private val repository: BarCodeRepository = BarCodeRepository(application)


    val getNonExpiredItems = repository.getAllNonExpiredItems()
    val getExpiredItems = repository.getAllExpiredItems()

    fun insertItem(barCodeItem: BarCodeItem) {
        viewModelScope.launch {
            repository.insertItem(barCodeItem)

            val workRequest =
                OneTimeWorkRequest.Builder(NotificationWorker::class.java)
                    .setInitialDelay(barCodeItem.expiredDays.toLong(), TimeUnit.DAYS)
                    .build()

            workManager.enqueue(workRequest)


        }
    }

    fun deleteAllItems() {
        viewModelScope.launch {
            repository.deleteAllItem()
        }
    }

}
