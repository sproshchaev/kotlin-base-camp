package com.prosoft.webinar04

fun main() {
    print("Введите символ: ")
    val ch = readln().first()
    println("Следующий: ${ch + 1}")
    println("Предыдущий: ${ch - 1}")

    var letter = 'A'
    letter += 10
    println("'A' + 10 = $letter")   // 'K'
    println("++letter = ${++letter}") // 'L'
    println("--letter = ${--letter}") // 'K'
}