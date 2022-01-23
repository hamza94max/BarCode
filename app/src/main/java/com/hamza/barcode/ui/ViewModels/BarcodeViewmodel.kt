package com.hamza.barcode.ui.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.hamza.barcode.Workmanger.NotificationWorker
import com.hamza.barcode.data.Models.BarCodeContent
import com.hamza.barcode.data.Repository.BarCodeRepository
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class BarcodeViewmodel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(this.getApplication())

    private val repository: BarCodeRepository = BarCodeRepository(application)

    /**
     * here we get non-expired products to implement it in Home fragment
     * and the expired products to implement it in Expired fragment
     */

    val getNonexpiredItems by lazy { repository.AllNonexpiredItems() }
    val getexpiredItems by lazy { repository.AllexpiredItems() }

    fun insertItem(barCodeContent: BarCodeContent) {
        viewModelScope.launch {
            repository.insertItem(barCodeContent)

            val WorkRequest =
                OneTimeWorkRequest.Builder(NotificationWorker::class.java)
                    .setInitialDelay(barCodeContent.expiredDays.toLong(), TimeUnit.DAYS)
                    .build()

            workManager.enqueue(WorkRequest)


        }
    }

}
