package com.example.viewmodelapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    private val _message = MutableLiveData<String>()
    private val _clicks = MutableLiveData<Int>()
    val message: LiveData<String> get() = _message
    val clicks: LiveData<Int> get() = _clicks

    init {
        _message.value = ""
        _clicks.value = 0
        Log.i("VIEWMODEL_APP", "Viewmodel creado")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("VIEWMODEL_APP", "Viewmodel destruido")
    }

    fun hello(name: String) {
        _message.value = "hola $name"
        _clicks.value = clicks.value?.plus(1)
    }

    fun goodbye(name: String) {
        _message.value = "Adios $name"
        _clicks.value = clicks.value?.plus(1)
    }


}