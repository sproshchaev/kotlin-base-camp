package com.prosoft.webinar08

open class Animal {
    open fun sound(): String = "..."
}

class Dog : Animal() {
    override fun sound(): String = "Гав"
}

class Cat : Animal() {
    override fun sound(): String = "Мяу"
}

fun describe(animal: Animal) {
    println("Животное говорит: ${animal.sound()}")
}

fun main() {
    describe(Dog())
    describe(Cat())
}
// Животное говорит: Гав
// Животное говорит: Мяу