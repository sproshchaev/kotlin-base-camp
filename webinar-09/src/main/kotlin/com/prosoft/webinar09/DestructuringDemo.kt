package com.prosoft.webinar09

data class Person(val name: String, val age: Int, val isAdmin: Boolean)

fun main() {
    val (name, age, isAdmin) = Person("Anna", 30, true)
    println("$name, $age, $isAdmin")

    val persons = listOf(Person("Bob", 25, false), Person("Eve", 40, true))
    for ((n, _, admin) in persons) {        // _ пропускает поле
        if (!admin) println("$n — обычный пользователь")
    }
}