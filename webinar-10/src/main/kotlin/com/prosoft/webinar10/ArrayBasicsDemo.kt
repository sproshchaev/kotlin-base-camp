package com.prosoft.webinar10

fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    println(numbers.joinToString())   // 1, 2, 3, 4, 5
    println(numbers.size)             // 5

    numbers[0] = 100                  // меняем элемент по индексу
    println(numbers.joinToString())   // 100, 2, 3, 4, 5

    println(numbers.first())          // 100
    println(numbers.last())           // 5

    // массив заданного размера, заполненный по функции от индекса
    val squares = IntArray(5) { i -> i * i }
    println(squares.joinToString())   // 0, 1, 4, 9, 16
}