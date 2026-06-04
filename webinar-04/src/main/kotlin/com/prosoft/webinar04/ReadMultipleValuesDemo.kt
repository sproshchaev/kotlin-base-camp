package com.prosoft.webinar04

fun main() {
    println("Введите имя, возраст (число) и город через пробел:")
    val (name, ageStr, city) = readln().split(" ")
    val age = ageStr.toInt()
    println("Имя: $name, возраст: $age, город: $city")
}