package com.prosoft.webinar03

fun main() {
    var n: Int
    do {
        print("Введите положительное число: ")
        n = readln().toInt()
    } while (n <= 0)
    println("Вы ввели $n")
}