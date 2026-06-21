package com.prosoft.webinar11

class PredicateDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

            // хотя бы один чётный?
            println(numbers.any { it % 2 == 0 })  // true
            // все меньше 100?
            println(numbers.all { it < 100 })      // true
            // ни одного больше 100?
            println(numbers.none { it > 100 })     // true

            // важная особенность all() на пустой коллекции
            val empty = emptyList<Int>()
            println(empty.all { it > 100 }) // true (vacuous truth!)
        }
    }
}