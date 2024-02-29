package com.rja.coroutinesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData(){
        viewModelScope.launch {
            try {
                isLoading = true
                llamarAPI()
            }catch (e: Exception){
                println("Error")
            } finally {
                isLoading = false
            }
        }

    }

    private suspend fun llamarAPI(){
        val resultado = withContext(Dispatchers.IO){
                            delay(7000)
                            "Items de respuesta del API tras 5 segundos"
        }

        resultState = resultado
    }
}