package com.prosoft.webinar03

fun main() {
    val number = 15
    when {
        number < 0 -> println("Отрицательное")
        number in 1..10 -> println("От 1 до 10")
        number % 2 == 0 -> println("Чётное")
        else -> println("Нечётное и больше 10")
    }
}