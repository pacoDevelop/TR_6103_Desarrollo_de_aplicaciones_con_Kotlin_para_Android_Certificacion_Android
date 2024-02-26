package com.example.explicitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val data=intent.extras?:return

        val mensaje=data.getString("data")
        val txMensaje : TextView = findViewById(R.id.textView2)
        txMensaje.text=mensaje
    }

    fun returnData(view: View){
        finish()
    }

    override fun finish() {
        val data = Intent()

        val resultString ="Dato devuelto desde subactividad"

        data.putExtra("returnData",resultString)

        setResult(RESULT_OK,data)

        super.finish()
    }

}