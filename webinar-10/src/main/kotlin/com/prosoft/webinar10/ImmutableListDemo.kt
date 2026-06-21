package com.prosoft.webinar10

fun main() {
    val cars = listOf("BMW", "Honda", "Mercedes")

    println(cars)                 // [BMW, Honda, Mercedes]
    println(cars[0])              // BMW — доступ по индексу
    println(cars.size)            // 3
    println(cars.contains("Honda")) // true

    // cars[0] = "Renault"        // не скомпилируется: List неизменяемый
}