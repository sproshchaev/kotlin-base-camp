package com.prosoft.webinar10

fun main() {
    val visitors = setOf("Vlad", "Vanya", "Liza", "Liza")

    println(visitors)                  // [Vlad, Vanya, Liza] — дубликат убран
    println(visitors.size)             // 3
    println(visitors.contains("Liza")) // true

    // из списка с повторами — в множество уникальных
    val groceries = listOf("Pen", "Apple", "Pen", "Apple")
    println(groceries.toSet())         // [Pen, Apple]
}