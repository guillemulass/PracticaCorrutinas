package com.gmulbat1301.practicacorrutinas.UserInterface

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel(application: Application) : AndroidViewModel(application){

    private val _apiCalls = MutableLiveData<Int>()
    val apiCalls : LiveData<Int> = _apiCalls


    private val _backgroundColor = MutableLiveData<Color>()
    val backgroundColor : LiveData<Color> = _backgroundColor

    private var alternator = true


    init {
        _apiCalls.value = 0
    }

    fun apiCaller(){
        Thread.sleep(5000)
        _apiCalls.value = _apiCalls.value!! + 1
    }

    fun colorChanger(){
        alternator = !alternator
       _backgroundColor.value = if (alternator) Color.Blue else Color.Red
    }


}