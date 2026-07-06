package com.prosoft.webinar15

// Пример 3. Эффективная сборка строк — StringBuilder и buildString
class StringBuilderDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // строки неизменяемы: каждое "+=" создаёт НОВЫЙ объект (медленно в цикле)
            // buildString — идиоматичная обёртка над StringBuilder
            val numbers = listOf(1, 2, 3, 4, 5)
            val result = buildString {
                for (n in numbers) {
                    append(n)      // добавляем число
                    append(' ')    // и пробел
                }
            }
            println(result) // 1 2 3 4 5

            // прямое использование StringBuilder с несколькими методами
            val sb = StringBuilder()
            sb.append("Hello World")
            sb.insert(5, ",")       // вставка по позиции
            sb.reverse()            // переворот
            println(sb.toString())  // dlroW ,olleH
        }
    }
}
