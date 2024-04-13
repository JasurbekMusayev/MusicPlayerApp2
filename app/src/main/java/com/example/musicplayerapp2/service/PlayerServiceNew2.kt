package com.example.musicplayerapp2.service

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.musicplayerapp2.R

class PlayerServiceNew2 : Service() {

    companion object {
        const val STARTFOREGROUND_ACTION = "com.example.musicplayer.action.START_FOREGROUND"
        const val STOPFOREGROUND_ACTION = "com.example.musicplayer.action.STOP_FOREGROUND"


        const val NOTIFICATION_CHANNEL_ID = "musicplayer_channel"
    }

    private val NOTIFICATION_ID = 1

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.mockingbird)
        mediaPlayer.isLooping = true
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (intent.action == STARTFOREGROUND_ACTION) {
            startForeground(NOTIFICATION_ID, createNotification())
            playMusic()
            isPlaying = true
        } else if (intent.action == STOPFOREGROUND_ACTION) {
            stopForeground(true)
            stopMusic()
            isPlaying = false
            stopSelf()
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isPlaying) {
            stopMusic()
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun createNotification(): Notification {
        val stopIntent = Intent(this, PlayerServiceNew2::class.java)
        stopIntent.action = STOPFOREGROUND_ACTION
        val pendingStopIntent =
            PendingIntent.getService(this, 0, stopIntent, PendingIntent.FLAG_MUTABLE)
        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Music Player")
            .setContentText("Playing Music")
            .setSmallIcon(R.drawable.believer)
            .addAction(R.drawable.ic_pause, "Stop", pendingStopIntent)
        return builder.build()
    }

    private fun playMusic() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    private fun stopMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPlayer.seekTo(0)
        }
    }


}