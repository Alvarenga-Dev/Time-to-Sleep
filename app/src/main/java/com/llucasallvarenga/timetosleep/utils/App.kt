package com.llucasallvarenga.timetosleep.utils

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationsChannels()
    }

    private fun createNotificationsChannels() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(
                    Consts.CHANNEL1ID,
                    Consts.CHANNEL1Name,
                    NotificationManager.IMPORTANCE_HIGH
            )

            channel1.description = "This is channel1"

            // ~~> Registra o canal no sistema
            val notificationManager : NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel1)

        }
    }
}
