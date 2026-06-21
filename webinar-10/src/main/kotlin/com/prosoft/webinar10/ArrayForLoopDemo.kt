package com.prosoft.webinar10

fun main() {
    // заполнение массива из одной строки ввода: "1 2 3 4 5"
    val numbers = readln().split(" ").map { it.toInt() }.toTypedArray()

    // перебор по элементам
    for (n in numbers) {
        print("$n ")
    }
    println()

    // перебор по индексам в обратном порядке
    for (i in numbers.lastIndex downTo 0) {
        print("${numbers[i]} ")
    }
    // ввод: 1 2 3 4 5  ->  вывод: 5 4 3 2 1
}