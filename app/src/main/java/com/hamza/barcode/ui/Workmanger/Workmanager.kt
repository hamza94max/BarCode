package com.hamza.barcode.ui.Workmanger

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hamza.barcode.R

class Workmanager(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    private val notificationManager =
        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

    override fun doWork(): Result {
        displayNotification("The product //name is expired today, Don't use it for your health ")
        return Result.success()
    }

    private fun displayNotification(content: String) {

        createChannel()
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notification: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext, "Channel 1"

        ).setContentText(content)
            .setSmallIcon(R.drawable.ic_baseline_qr_code_scanner_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setSound(uri)

        notificationManager.notify(1, notification.build())
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(
                    "Channel 1",
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
                )
            notificationManager.createNotificationChannel(channel)
        }
    }
}