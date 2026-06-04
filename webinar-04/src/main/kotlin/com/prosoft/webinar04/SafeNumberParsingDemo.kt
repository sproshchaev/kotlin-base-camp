package com.prosoft.webinar04

fun main() {
    print("Введите год: ")
    val input = readln()
    val year = input.toIntOrNull() ?: error("Год должен быть числом, а не «$input»")
    println("Введён год: $year")
}