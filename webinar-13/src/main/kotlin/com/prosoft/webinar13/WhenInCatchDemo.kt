package com.prosoft.webinar13

// Пример 5. Компактный перехват через when внутри catch
class WhenInCatchDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = "0"
            try {
                println(100 / input.toInt())
            } catch (e: Exception) {
                when (e) {
                    is NumberFormatException -> println("You didn't type an INT number!")
                    is ArithmeticException -> println("You typed 0!")
                    else -> println("What else can go wrong!")
                }
            }
        }
    }
}
