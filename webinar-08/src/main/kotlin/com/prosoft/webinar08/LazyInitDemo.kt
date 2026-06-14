package com.prosoft.webinar08

fun main() {
    val heavy: String by lazy {
        println("Вычисляю значение...")
        "Готово"
    }

    println("До первого обращения")
    println(heavy)   // Вычисляю значение... / Готово
    println(heavy)   // Готово (повторно не вычисляется)
}