package com.prosoft.webinar04

fun main() {
    print("Введите true или false (строго): ")
    val input = readln()
    val result = input.toBooleanStrictOrNull()
    if (result == null) {
        println("Ошибка: '$input' не является true или false")
    } else {
        println("Преобразовано: $result")
    }
}