package com.prosoft.webinar10

fun main() {
    val words = mutableSetOf("Apple", "Coke")

    words.add("Phone")
    words.add("Apple")       // дубликат — множество не изменится
    println(words)           // [Apple, Coke, Phone]

    val friendsWords = setOf("Banana", "Coke")
    words.addAll(friendsWords)   // объединяем, "Coke" не задвоится
    println(words)               // [Apple, Coke, Phone, Banana]

    words.remove("Apple")
    println(words)               // [Coke, Phone, Banana]
}