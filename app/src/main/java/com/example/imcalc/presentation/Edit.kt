package com.example.imcalc.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Edit(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    action: ImeAction = ImeAction.Next,
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text( label, fontSize = 16.sp) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal,
            imeAction = action
        ),
        modifier = Modifier.padding(bottom = 8.dp )
    )
}