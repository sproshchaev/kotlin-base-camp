package com.prosoft.webinar15

// Пример 1. Форматирование строк — String.format()
class StringFormatDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // %s — строка, %d — целое, порядок аргументов по умолчанию
            val info = String.format("%s is %d years old", "Kotlin", 15)
            println(info) // Kotlin is 15 years old

            // альтернативный синтаксис — format прямо на строке-шаблоне
            println("%S".format("hello")) // HELLO (заглавными)

            // %05d — ширина 5, добиваем ведущими нулями
            println(String.format("%05d", 42)) // 00042

            // %.2f — два знака после запятой, число округляется
            println(String.format("Price: %.2f", 1234.5678)) // Price: 1234.57
        }
    }
}
