package com.prosoft.webinar10

fun main() {
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri")

    // 1) по элементам
    for (day in daysOfWeek) {
        println(day)
    }

    // 2) по индексам
    for (index in daysOfWeek.indices) {
        println("$index: ${daysOfWeek[index]}")
    }
}