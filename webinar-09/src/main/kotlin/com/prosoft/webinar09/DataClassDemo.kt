package com.prosoft.webinar09

data class Client(val name: String, val age: Int)

fun main() {
    val bob = Client("Bob", 29)
    val john = bob.copy(name = "John")   // copy с изменением поля

    println(bob)                 // Client(name=Bob, age=29)
    println(bob == Client("Bob", 29))  // true — сравнение по полям
    println(john)                // Client(name=John, age=29)
}