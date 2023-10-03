package com.example.imcalc.domain.imc

import java.text.NumberFormat

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