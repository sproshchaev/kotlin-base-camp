package com.prosoft.webinar15

// Пример 2. Разбиение строки — split()
class StringSplitDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // разбиение по пробелу — получаем список слов
            val words: List<String> = "a long text".split(" ")
            println(words) // [a, long, text]

            // разбиение телефона по дефису
            val parts = "+1-213-345-6789".split("-")
            println(parts) // [+1, 213, 345, 6789]

            // все части — строки, даже если выглядят как числа
            println(parts[1]::class.simpleName) // String

            // разделителем может быть целое слово
            println("I'm gonna be a programmer".split(" gonna be ")) // [I'm, a programmer]
        }
    }
}
