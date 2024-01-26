package com.gmulbat1301.practicacorrutinas.UserInterface

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel(application: Application) : AndroidViewModel(application){

    var apiCalls by mutableIntStateOf(0)
    var backgroundColor by mutableStateOf(Color.DarkGray)
    var isLoading by mutableStateOf(false)

    private var alternator = true


    fun colorChanger(){
        alternator = !alternator
        backgroundColor = if (alternator) Color.Blue else Color.Red
    }

    fun fetchData() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                apiCalls = apiCalls.plus(1)
            }
        }
    }

    fun fetchDataa() {
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            apiCalls = apiCalls.plus(1)
        }
    }
}