package com.prosoft.webinar15

// Пример 4. Создание Regex и полное совпадение — matches()
class RegexBasicsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // два эквивалентных способа создать Regex
            val regex1 = "cat".toRegex()   // через метод на строке
            val regex2 = Regex("cat")      // через конструктор

            // matches() требует полного совпадения ВСЕЙ строки
            println(regex2.matches("cat"))  // true  — совпадает целиком
            println(regex2.matches("dog"))  // false — не совпадает
            println(regex2.matches("cats")) // false — лишняя 's', не вся строка

            // регулярки чувствительны к регистру
            println(Regex("cat").matches("CAT")) // false
        }
    }
}
