package com.prosoft.webinar03

fun main() {
    println("Чётные от 2 до 8:")
    for (i in 2..8 step 2) print("$i ")

    println("\nОбратный порядок от 6 до 1:")
    for (i in 6 downTo 1) print("$i ")
}