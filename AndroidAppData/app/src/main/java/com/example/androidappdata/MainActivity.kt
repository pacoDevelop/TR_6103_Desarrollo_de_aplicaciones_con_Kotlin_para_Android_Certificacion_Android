package com.example.androidappdata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.androidappdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{updateMessage()}
        if(savedInstanceState!=null){
            binding.text.text=savedInstanceState.getString("message")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("message",binding.text.text.toString())
    }

    private fun updateMessage() {
        val username = binding.editTextText.text

        val messages = listOf("Manten en forma","Buenos dias","Feliz tarde","Happy coding")
        val index =messages.indices.random()

        val activeMessage=messages[index]

        if(username.toString()==""){
            binding.text.text=getString(R.string.make_sure)
        }else{
            binding.text.text="Frase del dia $username es :  $activeMessage"
        }

        binding.editTextText.setText("")
        hideKeyboard()
    }

    private fun hideKeyboard(){
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.editTextText.windowToken, Int.MIN_VALUE)
    }

}