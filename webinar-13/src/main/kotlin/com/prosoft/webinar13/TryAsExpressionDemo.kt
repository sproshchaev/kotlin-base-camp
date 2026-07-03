package com.prosoft.webinar13

// Пример 6. try как выражение, безопасный парсинг
class TryAsExpressionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val number: Int = try {
                "abc".toInt()
            } catch (e: NumberFormatException) {
                0
            }
            println(number)   // 0
        }
    }
}
