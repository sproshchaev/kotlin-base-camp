package com.prosoft.webinar06

fun printInfo(obj: Any) {
    if (obj is String) {
        // obj здесь уже String — доступны строковые методы без приведения
        println("Длина строки: ${obj.length}")
    }
}

fun main() {
    printInfo("Kotlin")   // Длина строки: 6
    printInfo(42)         // ничего не печатает — не String
}