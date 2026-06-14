package com.prosoft.webinar08

open class Vehicle(val brand: String) {
    fun info(): String = "Транспорт марки $brand"
}

class Car(brand: String, val doors: Int) : Vehicle(brand)

fun main() {
    val car = Car("Toyota", 4)
    println(car.info())          // метод унаследован от Vehicle
    println("Дверей: ${car.doors}")
}
// Транспорт марки Toyota
// Дверей: 4