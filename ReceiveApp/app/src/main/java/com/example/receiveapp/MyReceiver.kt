package com.example.receiveapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val message ="El mensaje detectado es por la accion "+ intent.action
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()
    }
}