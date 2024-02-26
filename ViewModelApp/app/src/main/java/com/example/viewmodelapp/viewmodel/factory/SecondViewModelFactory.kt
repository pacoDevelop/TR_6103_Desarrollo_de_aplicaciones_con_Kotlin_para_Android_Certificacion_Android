package com.example.viewmodelapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelapp.viewmodel.SecondViewModel

class SecondViewModelFactory(var passedClicks: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondViewModel::class.java)) {
            return SecondViewModel(passedClicks) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}