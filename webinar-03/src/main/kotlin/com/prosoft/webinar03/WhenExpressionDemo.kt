package com.prosoft.webinar03

fun main() {
    val number = 3
    val message = when (number) {
        1 -> "Один"
        2 -> "Два"
        3 -> "Три"
        else -> "Много"
    }
    println(message)
}