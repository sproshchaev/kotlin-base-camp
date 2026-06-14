package com.prosoft.webinar08

open class Person(val name: String)

class Employee(name: String, val id: Int) : Person(name) {
    fun card(): String = "$name (ID: $id)"
}

fun main() {
    val e = Employee("Анна", 42)
    println(e.card())
    println(e.name)   // унаследованное свойство родителя
}
// Анна (ID: 42)
// Анна