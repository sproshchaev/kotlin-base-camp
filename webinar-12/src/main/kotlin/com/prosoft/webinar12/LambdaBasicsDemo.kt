package com.prosoft.webinar12

// функция принимает другую функцию (transform) как параметр
fun applyAndSum(a: Int, b: Int, transform: (Int) -> Int): Int =
    transform(a) + transform(b)

class LambdaBasicsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val square: (Int) -> Int = { x -> x * x }   // лямбда в переменной, тип (Int) -> Int
            val typeProbe: (Int) -> Int = square         // тот же тип — лямбду можно копировать

            println(square(5))                       // 25
            println(typeProbe(5))                    // 25
            println(applyAndSum(1, 2, square))       // 5   (1*1 + 2*2)
            println(applyAndSum(3, 4) { it + 10 })   // 27  (13 + 14), trailing lambda
        }
    }
}
