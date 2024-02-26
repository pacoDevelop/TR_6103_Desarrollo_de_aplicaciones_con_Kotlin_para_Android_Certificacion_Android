package com.example.viewmodelapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel(passedClicks: Int) : ViewModel() {
    private val _clicks = MutableLiveData<Int>()
    val clicks: LiveData<Int> get() = _clicks

    init {
        _clicks.value = passedClicks + 1
    }

    fun addClicks() {
        _clicks.value = _clicks.value?.plus(1)
    }
}