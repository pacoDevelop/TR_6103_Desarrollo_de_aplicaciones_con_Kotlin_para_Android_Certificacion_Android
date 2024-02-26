package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
//            val intent: Intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pue.es"))
//            val chooserIntent =Intent.createChooser(intent,null)
            val intent :Intent=Intent().apply {
                action=Intent.ACTION_VIEW
                data=Uri.parse("https://www.pue.es")
            }

            startActivity(intent)
        }
    }
}