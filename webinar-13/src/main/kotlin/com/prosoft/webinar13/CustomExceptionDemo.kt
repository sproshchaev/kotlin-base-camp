package com.prosoft.webinar13

// Пример 8. Своё исключение: создание, бросок, перехват
fun checkPositive(value: Int) {
    if (value < 0) throw LessThanZero()
    println("Value is OK: $value")
}

class CustomExceptionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                checkPositive(-5)
            } catch (e: LessThanZero) {
                println("Caught: ${e.message}")   // Caught: Parameter less than zero
            }
            checkPositive(10)                      // Value is OK: 10
        }
    }
}
