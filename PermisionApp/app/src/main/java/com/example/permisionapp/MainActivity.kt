package com.example.permisionapp

import android.Manifest
import android.Manifest.permission.RECORD_AUDIO
import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat

class MainActivity : AppCompatActivity() {

    private val TAG="Permisos app"
    private val REQUEST_CODE=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPermissions()
    }

    private fun setupPermissions() {
        val permisionAudio=ContextCompat.checkSelfPermission(this, RECORD_AUDIO)
        if(permisionAudio!=PackageManager.PERMISSION_GRANTED){
          Log.i(TAG,"NOT PERMISSION RECORD")
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,RECORD_AUDIO)){
                Log.i(TAG,"ABRIENDO DIALOGO")
                val builder=AlertDialog.Builder(this)
                builder.setTitle("recuerdo de permisos")
                    .setMessage("te recuerdo el permiso de audio es necesario para cositas")
                    .setPositiveButton("ok"){ dialog,id->
                       makeRequest()
                    }
               val dialog= builder.create()
                dialog.show()
            }else{
                makeRequest()
            }
        }

    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(RECORD_AUDIO),REQUEST_CODE)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE->{
                if(grantResults.isEmpty() || grantResults[0]!=
                    PackageManager.PERMISSION_GRANTED){
                    Log.i(TAG,"El permiso ha sido aceptado")
                }else{
                    Log.i(TAG,"El permiso no ha sido aceptado")
                }

            }
        }
    }
}