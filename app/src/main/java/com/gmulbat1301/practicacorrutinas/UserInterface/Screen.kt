package com.gmulbat1301.practicacorrutinas.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf

@Composable
fun Screen(
    viewModel: ViewModel
){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        ColorButton(viewModel)
        Spacer(modifier = Modifier.padding(10.dp))
        APIButton(viewModel)
        Spacer(modifier = Modifier.padding(10.dp))
        ApiText(viewModel)
    }


}

@Composable
fun ColorButton(
    viewModel: ViewModel
){

    val backgroundColor: Color by viewModel.backgroundColor.observeAsState(Color.DarkGray)

    Button(
        shape = RectangleShape,
        onClick = {
            viewModel.colorChanger()
        } ,
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text = "Cambiar color",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }



}

@Composable
fun APIButton(
    viewModel: ViewModel
){
    Button(
        shape = RectangleShape,
        onClick = {
            viewModel.apiCaller()
        } ,
        colors = ButtonDefaults.buttonColors(Color.DarkGray)
    ) {
        Text(
            text = "Llamar API",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ApiText(
    viewModel: ViewModel
){
    //val apiCalls: Int by mutableStateOf(0)

    val apiCalls: Int by viewModel.apiCalls.observeAsState(0)

    Text(
        text = if (apiCalls == 0) "" else "Respuesta API: $apiCalls",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
}