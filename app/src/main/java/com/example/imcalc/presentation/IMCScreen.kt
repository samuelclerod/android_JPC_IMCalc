package com.example.imcalc.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imcalc.domain.imc.formattedIMC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IMCScreen(modifier: Modifier = Modifier) {
    var inputWeight by remember { mutableStateOf("") }
    var inputHeight by remember {  mutableStateOf("") }
    var imc by remember { mutableStateOf("") }

    val weight = inputWeight.toDoubleOrNull()
    val height = inputHeight.toDoubleOrNull()

    val onclick =  { imc = formattedIMC(weight, height) }

    Column (
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Edit(
            value = inputWeight,
            onValueChange = { inputWeight = it},
            label = "Digite seu Peso",
        )
        Edit(
            value = inputHeight,
            onValueChange = { inputHeight = it},
            label = "Digite sua altura",
        )
        Button(onClick = onclick) {
            Text( "Calcular o IMC")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = imc,
            fontSize = 34.sp,
            modifier = modifier
        )
    }
}