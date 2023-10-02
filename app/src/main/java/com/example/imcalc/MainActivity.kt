package com.example.imcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imcalc.ui.theme.IMCalcTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMCalcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IMCLayout("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IMCLayout(name: String, modifier: Modifier = Modifier) {
    var inputWeight by remember { mutableStateOf("") }
    var inputHeight by remember {  mutableStateOf("") }
    var imc by remember { mutableStateOf("") }

    val weight = inputWeight.toDoubleOrNull()
    val height = inputHeight.toDoubleOrNull()

    Column (
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = inputWeight,
            onValueChange = { inputWeight = it},
            label = { Text( "Digite seu Peso")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = inputHeight,
            onValueChange = { inputHeight = it},
            label = { Text( "Digite seu Peso")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Send,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { imc = formattedIMC(weight, height) }) {
            Text( "Calcular o IMC")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = imc,
            modifier = modifier
        )
    }
}

fun formattedIMC(
    weight: Double?,
    height: Double?,
): String {
    if (weight == null || height == null){
        return "Digite valores válidos"
    }
    val imc = weight /(height*height)
    val textIMC = NumberFormat.getNumberInstance().format(imc)
    return "Seu IMC é $textIMC"
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMCalcTheme {
        IMCLayout("Android")
    }
}