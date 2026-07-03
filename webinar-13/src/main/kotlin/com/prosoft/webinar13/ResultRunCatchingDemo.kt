package com.prosoft.webinar13

// Пример 12. Result через runCatching + fold
fun parseYear(input: String): Result<Int> = runCatching {
    val n = input.toInt()
    require(n in 1450..2100) { "Год $n вне диапазона" }
    n
}

class ResultRunCatchingDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            parseYear("2008").fold(
                onSuccess = { println("Год: $it") },            // Год: 2008
                onFailure = { println("Ошибка: ${it.message}") }
            )
            parseYear("xyz").fold(
                onSuccess = { println("Год: $it") },
                onFailure = { println("Ошибка: ${it.message}") } // Ошибка: неверный ввод
            )
        }
    }
}
