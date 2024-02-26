package com.example.helloworld

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

//MainActivity extends from AppCompatActivity giving it more functionality.
class MainActivity : AppCompatActivity() {
    //onCreate is a lifecycle method that runs only once at the start of the app.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Imprimir mensaje en la consola de registro (Logcat)
        println("¡Hola desde Kotlin!")
        Log.i("HW","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("HW","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("HW","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("HW","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("HW","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("HW","onDestroy")
    }


    //Override all lifecycle methods to learn about them!
    

}