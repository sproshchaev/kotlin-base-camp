package com.prosoft.webinar13

// Пример 1. Необработанное исключение — падение программы, stack trace
class DivisionCrashDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Начало программы")
            val a = 0
            val b = 10 / a               // ArithmeticException: / by zero
            println("Конец программы")   // эта строка не выполнится
        }
    }
}
