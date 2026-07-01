package com.prosoft.webinar12

fun isOdd(x: Int) = x % 2 != 0

// принимает предикат (Int) -> Boolean и применяет его к каждому элементу
fun List<Int>.printMatching(predicate: (Int) -> Boolean) {
    for (n in this) if (predicate(n)) print("$n ")
    println()
}

class HigherOrderFunctionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = listOf(1, 2, 3, 4, 5, 6)
            nums.printMatching { it > 3 }      // 4 5 6
            nums.printMatching(::isOdd)        // 1 3 5
            val evens = nums.filter { it % 2 == 0 }
            println(evens)                     // [2, 4, 6]
        }
    }
}
