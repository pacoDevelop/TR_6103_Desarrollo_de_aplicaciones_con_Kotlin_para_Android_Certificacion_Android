package com.rja.servicesapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    var isBound = false
    var boundedService: BoundedService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //vinculacion al servicio
        val intent = Intent(this, BoundedService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)

        //unbindService(serviceConnection)
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundedService.MyBinder
            boundedService = binder.getService()
            Log.d("MainActivity", "Service Connected")
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("MainActivity", "Service Disconnected")
            isBound = false
        }
    }

    fun showTime(view: View) {
        if (isBound) {
            val currentTime = boundedService?.getCurrentTime()
            Log.d("MainActivity", "Current Time: $currentTime")
        }
    }

    fun initService(view: View) {
        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)
    }

    fun disconnectService(view: View) {
        if (isBound) {
            unbindService(serviceConnection)
            isBound = false
        }
    }
}