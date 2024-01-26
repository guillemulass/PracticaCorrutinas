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

    private var alternator = true


    fun fetchData() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                apiCalls = apiCalls.plus(1)
            }
        }
    }

    fun colorChanger(){
        alternator = !alternator
        backgroundColor = if (alternator) Color.Blue else Color.Red
    }


}