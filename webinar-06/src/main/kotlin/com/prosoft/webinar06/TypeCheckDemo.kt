package com.prosoft.webinar06

fun describe(input: Any): String = when (input) {
    is Int    -> "Целое число"
    is String -> "Строка"
    is Double -> "Дробное число"
    else      -> "Неизвестный тип"
}

fun main() {
    println(describe(42))        // Целое число
    println(describe("hello"))   // Строка
    println(describe(3.14))      // Дробное число
    println(describe(true))      // Неизвестный тип
}