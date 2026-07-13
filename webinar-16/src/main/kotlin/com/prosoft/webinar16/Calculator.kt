package com.prosoft.webinar16

// Пример 1. Класс под тестирование — наш «подопытный» для всех примеров с JUnit.
class Calculator {
    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
    fun multiply(a: Int, b: Int) = a * b

    fun divide(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException("Divisor cannot be zero!")
        return a / b
    }

    fun isEven(a: Int) = (a % 2) == 0

    fun maxOf(a: Int, b: Int) = if (a >= b) a else b
}
