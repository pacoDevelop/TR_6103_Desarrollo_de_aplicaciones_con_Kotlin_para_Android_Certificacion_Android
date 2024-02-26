package com.example.notificationapp

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import java.io.PipedInputStream

class MainActivity : AppCompatActivity() {
    private var notificationManager:NotificationManager?=null
    private val NOTIFICATION_RESQUEST_ID=1001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(Manifest.permission.POST_NOTIFICATIONS,NOTIFICATION_RESQUEST_ID)
        //crear el manager
        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //crear el canal
        createNotificationChannel("$packageName.mainActivity","news","News on 2023")

    }

    private fun requestPermissions(permissionType: String, requestCode: Int) {
        val permission = ContextCompat.checkSelfPermission(this,
            permissionType)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(permissionType), requestCode
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            NOTIFICATION_RESQUEST_ID->{
                if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permisos requeridos",Toast.LENGTH_LONG).show()
                }
            }


        }
    }


    private fun createNotificationChannel(id:String,name:String,description:String) {
        //importancia
        val importance=NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id,name,importance)
        channel.description=description
        channel.enableLights(true)
        channel.lightColor= Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern= longArrayOf(100,200,300)

        notificationManager?.createNotificationChannel(channel)
    }

    fun sendNotifaction(view: View){

        val intent = Intent(this, SecondActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)

//        val notification=Notification.Builder(applicationContext,packageName)
//            .setContentTitle("Notificación sesion android")
//            .setContentText("Info de la sesion de android")
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setChannelId("$packageName.mainActivity")
//            .build()

        val notification=Notification.Builder(applicationContext,packageName)
            .setContentTitle("Notificación sesion android")
            .setContentText("Info de la sesion de android")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setChannelId("$packageName.mainActivity")
            .setContentIntent(pendingIntent)
            .build()


        notificationManager?.notify(NOTIFICATION_RESQUEST_ID,notification)
    }
}