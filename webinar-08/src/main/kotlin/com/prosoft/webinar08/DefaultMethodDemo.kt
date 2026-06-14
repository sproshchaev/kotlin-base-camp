package com.prosoft.webinar08

interface Greeter {
    val language: String
        get() = "ru"                      // свойство через геттер (без состояния)

    fun greet(name: String): String       // абстрактный — реализовать обязан

    fun greetAll(names: List<String>): String =   // реализация по умолчанию
        names.joinToString(", ") { greet(it) }
}

class FriendlyGreeter : Greeter {
    override fun greet(name: String): String = "Привет, $name!"
}

fun main() {
    val g = FriendlyGreeter()
    println(g.greet("Иван"))
    println(g.greetAll(listOf("Аня", "Петя")))  // метод по умолчанию
    println("Язык: ${g.language}")               // свойство по умолчанию
}
// Привет, Иван!
// Привет, Аня!, Привет, Петя!
// Язык: ru