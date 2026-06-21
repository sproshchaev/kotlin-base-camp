package com.prosoft.webinar11

class MappingDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbers = listOf(1, 2, 3, 4, 5)
            val words = listOf("anne", "michael", "caroline")

            // преобразование каждого элемента
            println(numbers.map { it * 2 })       // [2, 4, 6, 8, 10]
            println(words.map { it.uppercase() }) // [ANNE, MICHAEL, CAROLINE]
            println(words.map { it.length })      // [4, 7, 8]

            // map + отсев непреобразуемых (null)
            val raw = listOf("1", "2", "abc", "4")
            println(raw.mapNotNull { it.toIntOrNull() }) // [1, 2, 4]

            // преобразование значений словаря
            val map = mapOf(1 to "one", 2 to "two", 3 to "three")
            println(map.mapValues { it.value.uppercase() }) // {1=ONE, 2=TWO, 3=THREE}

            // flatMap — разворачивание вложенных коллекций (один-ко-многим)
            val nested = listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
            println(nested.flatMap { it.map { x -> x * 10 } }) // [10, 20, 30, 40, 50, 60]
        }
    }
}