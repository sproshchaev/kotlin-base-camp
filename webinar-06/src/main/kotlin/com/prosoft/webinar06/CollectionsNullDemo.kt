package com.prosoft.webinar06

fun main() {
    val nullableList: List<Int>? = null              // null может быть сам список
    val withNulls: List<Int?> = listOf(1, null, 3)   // null может быть элемент

    // безопасно разворачиваем сам список
    val safe: List<Int?> = nullableList ?: listOf()
    println(safe)            // []

    // чистим от null-элементов одним вызовом
    val clean = listOfNotNull(1, null, 3, null, 5)
    println(clean)          // [1, 3, 5]

    // безопасная выборка по индексу
    println(withNulls.getOrNull(5) ?: "нет элемента")  // нет элемента
}