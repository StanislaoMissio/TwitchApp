package com.example.projecttwitch.utils

import java.text.DecimalFormat
import java.text.NumberFormat

class StringUtils {

    companion object {
        fun language(text: String): String {
            return when (text) {
                "en" -> "Inglês"
                "pt" -> "Português"
                "ru" -> "Russo"
                "fr" -> "Francês"
                "ko" -> "Coreano"
                "de" -> "Alemão"
                "it" -> "Italiano"
                else -> text
            }
        }

        fun decimalFormat(number: Int): String {
            val numberFormat = DecimalFormat()
            return numberFormat.format(number)
        }
    }

}