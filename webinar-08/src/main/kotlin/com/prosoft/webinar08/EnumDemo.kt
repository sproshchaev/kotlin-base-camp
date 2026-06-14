package com.prosoft.webinar08

enum class Status(val label: String) {
    OPEN("Открыт"),
    IN_PROGRESS("В работе"),
    CLOSED("Закрыт");

    fun describe() = "$name -> $label"
}

fun main() {
    println(Status.OPEN.describe())       // OPEN -> Открыт
    println(Status.IN_PROGRESS.ordinal)   // 1
    for (s in Status.entries) println(s.label)
    println(Status.valueOf("CLOSED"))     // CLOSED
}