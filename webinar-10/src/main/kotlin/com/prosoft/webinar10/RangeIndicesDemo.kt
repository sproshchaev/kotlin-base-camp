package com.prosoft.webinar10

fun main() {
    val items = listOf("A", "B", "C", "D", "E", "F", "G")

    // часть списка: индексы 1..4 включительно
    for (index in 1..4) {
        println("$index: ${items[index]}")
    }

    // в обратном порядке с шагом 2
    for (index in items.lastIndex downTo 0 step 2) {
        println("$index: ${items[index]}")
    }
}