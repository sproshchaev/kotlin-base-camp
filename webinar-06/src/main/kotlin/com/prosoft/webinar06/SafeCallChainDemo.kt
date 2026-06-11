package com.prosoft.webinar06

data class Address(val street: String?)
data class City(val address: Address?)

fun main() {
    val city1: City? = City(Address("Main St"))
    val city2: City? = City(null)
    val city3: City? = null

    println(city1?.address?.street)   // Main St
    println(city2?.address?.street)   // null — оборвалось на address
    println(city3?.address?.street)   // null — оборвалось на city
}