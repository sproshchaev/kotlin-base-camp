package com.prosoft.webinar10

fun main() {
    val places = mutableListOf("Paris", "Moscow", "Tokyo")

    places.add("Saint-Petersburg")    // добавили в конец
    places[0] = "Berlin"              // заменили по индексу (set)
    places.removeAt(1)                // удалили по индексу
    places.remove("Tokyo")            // удалили по значению

    println(places)                   // [Berlin, Saint-Petersburg]
    println(places.size)              // 2
}