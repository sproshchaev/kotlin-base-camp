package com.prosoft.webinar12

class ScopeReturnDifferenceDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbers = mutableListOf(1, 2, 3)

            // apply возвращает САМ объект -> можно строить цепочку
            val same = numbers.apply { add(4) }.apply { add(5) }
            println(same)                       // [1, 2, 3, 4, 5]

            // run возвращает РЕЗУЛЬТАТ лямбды -> получаем вычисленное значение
            val howManyBig = numbers.run {
                add(15)
                count { it > 4 }                // последнее выражение
            }
            println(howManyBig)                 // 2  (это 5 и 15)
        }
    }
}
