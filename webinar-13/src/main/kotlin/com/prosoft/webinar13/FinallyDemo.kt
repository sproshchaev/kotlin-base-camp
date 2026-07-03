package com.prosoft.webinar13

// Пример 9. Блок finally — выполняется всегда
class FinallyDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Начало")
            val zero = 0
            try {
                val a = 10 / zero                    // ArithmeticException
                println(a)
            } catch (e: ArithmeticException) {
                println("Ловим исключение")
            } finally {
                println("Это выполнится в любом случае")
            }
            println("После try-catch-finally")
        }
    }
}
