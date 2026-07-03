package com.prosoft.webinar13

// Пример 3. Перехват исключения через try-catch
class TryCatchDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Начало")
            val zero = 0
            try {
                println(10 / zero)                   // ArithmeticException
                println("Это не будет напечатано")
            } catch (e: ArithmeticException) {
                println("Division by zero!")
            }
            println("Программа продолжается")
        }
    }
}
