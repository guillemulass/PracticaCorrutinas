package com.gmulbat1301.practicacorrutinas.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

    }


}

@Composable
fun ColorButton(
    viewModel: ViewModel
){

    Button(
        shape = RectangleShape,
        onClick = {
            viewModel.colorChanger()
        } ,
        colors = ButtonDefaults.buttonColors(viewModel.backgroundColor)
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
            viewModel.fetchData()
        } ,
        colors = ButtonDefaults.buttonColors(Color.DarkGray)
    ) {
        Text(
            text = "Llamar API",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Spacer(modifier = Modifier.padding(10.dp))
    if (viewModel.isLoading){
        CircularProgressIndicator(
            modifier = Modifier
                .size(150.dp)
        )
    }
    ApiText(viewModel)
}

@Composable
fun ApiText(
    viewModel: ViewModel
){

    Text(
        text = if (viewModel.apiCalls == 0) "" else "Respuesta API: ${viewModel.apiCalls}",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
}