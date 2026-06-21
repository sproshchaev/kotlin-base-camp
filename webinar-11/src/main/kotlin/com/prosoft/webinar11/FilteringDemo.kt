package com.prosoft.webinar11

class FilteringDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbers = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

            // оставить чётные
            println(numbers.filter { it % 2 == 0 })    // [0, 2, 4, 6, 8, 10]
            // оставить НЕ чётные
            println(numbers.filterNot { it % 2 == 0 }) // [1, 3, 5, 7, 9]

            // разбить на две коллекции за один проход
            val (even, odd) = numbers.partition { it % 2 == 0 }
            println(even) // [0, 2, 4, 6, 8, 10]
            println(odd)  // [1, 3, 5, 7, 9]

            // фильтрация по типу + отсев null
            val mixed = listOf(null, 0, "text", 3.14, 'c', "Luke")
            println(mixed.filterIsInstance<String>()) // [text, Luke]
            println(mixed.filterNotNull())            // [0, text, 3.14, c, Luke]
        }
    }
}