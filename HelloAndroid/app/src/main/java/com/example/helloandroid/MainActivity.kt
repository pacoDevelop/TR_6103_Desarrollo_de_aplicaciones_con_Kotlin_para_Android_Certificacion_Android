package com.example.helloandroid

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloandroid.databinding.ActivityMainBinding
import java.lang.String


class MainActivity : AppCompatActivity() {

    private lateinit  var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Creada")
    }

    fun setConvert(view: View){
        if(binding.editTextNumberDecimal.text.isNotEmpty()){
            val dollarValue=binding.editTextNumberDecimal.text.toString().toFloat();
            val euroValue=dollarValue*0.85f
            val formattedValue = String.format("%.2f €", euroValue)
            binding.textView1.text=formattedValue.toString();
        }else{
            binding.textView1.text="Sin dato"
        }
    }

    fun setConvertOld(view: View){
        val dollarText: EditText =findViewById(R.id.editTextNumberDecimal)
        val textView: TextView =findViewById(R.id.textView1)

        if(dollarText.text.isNotEmpty()){
            val dollarValue=dollarText.text.toString().toFloat();
            val euroValue=dollarValue*0.85f
            val formattedValue = String.format("%.2f €", euroValue)
            textView.text=formattedValue.toString();
        }else{
            textView.text="Sin dato"
        }
    }
}