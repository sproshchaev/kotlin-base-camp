package com.prosoft.webinar15

// Пример 5. Классы символов — наборы, диапазоны, сокращения
class RegexCharClassesDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // набор [bcr] — один из символов b, c или r
            println(Regex("[bcr]at").matches("rat")) // true
            println(Regex("[bcr]at").matches("fat")) // false — 'f' не в наборе

            // диапазон [0-9] — любая цифра; в raw-строке слэш пишем одинарный
            println(Regex("""[0-9]""").matches("7")) // true

            // сокращения: \d — цифра, \w — буква/цифра/подчёркивание
            println(Regex("""\d""").matches("5"))    // true
            println(Regex("""\w""").matches("_"))    // true

            // исключение: [^abc] — любой символ, КРОМЕ a, b, c
            println(Regex("[^abc]").matches("d"))    // true
            println(Regex("[^abc]").matches("a"))    // false
        }
    }
}
