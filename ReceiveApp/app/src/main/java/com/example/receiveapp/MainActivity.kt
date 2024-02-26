package com.example.receiveapp

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureReceiver()

    }

    private fun configureReceiver() {
        //Crear un intent filter
        val filter= IntentFilter()

        //action/s
        filter.addAction(packageName+".MY_ACTION")
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(Intent.ACTION_BOOT_COMPLETED)

        receiver = MyReceiver()
        registerReceiver(receiver,filter)
    }

    fun broadCastIntent(view: View){
        val intent = Intent()

        intent.action =packageName+".MY_ACTION"
        intent.flags =Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
}