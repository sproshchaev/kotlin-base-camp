package com.prosoft.webinar08

interface Flyer {
    fun fly(): String = "Лечу"
}

interface Swimmer {
    fun swim(): String = "Плыву"
}

class Duck : Flyer, Swimmer {
    fun describe(): String = "${fly()} и ${swim()}"
}

fun main() {
    val duck = Duck()
    println(duck.describe())
    println(duck is Flyer)    // true — утка является и тем, и другим
    println(duck is Swimmer)  // true
}
// Лечу и Плыву
// true
// true