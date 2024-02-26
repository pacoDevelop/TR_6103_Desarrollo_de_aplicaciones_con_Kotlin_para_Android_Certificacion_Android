package com.example.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webapp.databinding.ActivityMainBinding
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleIntent()
    }

    fun handleIntent(){
        val intent=this.intent;
        val data = intent.data
        var url:URL?=null
        try {
            url= URL(data?.scheme,data?.host,data?.path)
            binding.mainActivityWeb1.loadUrl(url.toString())
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}