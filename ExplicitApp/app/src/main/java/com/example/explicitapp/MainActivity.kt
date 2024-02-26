package com.example.explicitapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.let {
                if (it.hasExtra("returnData")) {
                    val resultString = it.extras?.getString("returnData")
                    val lbltxt: TextView = findViewById(R.id.textView)
                    lbltxt.text = resultString
                }
            }
        }
    }

    fun sendText(view: View) {
        //intent explicito

        val intent = Intent(this, SecondActivity::class.java)
        val edit: EditText = findViewById(R.id.editTextText);
        val text = edit.text.toString()
        intent.putExtra("data", text)
        //startActivity(intent)

        //subactivitity
        startForResult.launch(intent)
    }
}