package com.prosoft.webinar10

fun main() {
    val grades = mapOf(
        "Zhenya" to 5,
        "Vlad" to 4,
        "Nina" to 5
    )

    println(grades["Nina"])              // 5 — доступ по ключу
    println(grades.containsKey("Vlad"))  // true
    println(grades.containsValue(4))     // true
    println(grades.size)                 // 3
}