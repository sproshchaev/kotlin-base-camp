package com.prosoft.webinar15

// Пример 6. Кванторы — сколько раз повторяется символ
class RegexQuantifiersDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // + : одно или более вхождений
            println(Regex("ca+b").matches("cab"))     // true  — одна 'a'
            println(Regex("ca+b").matches("caaab"))   // true  — несколько 'a'
            println(Regex("ca+b").matches("cb"))      // false — ни одной 'a'

            // * : ноль или более (допускает отсутствие)
            println(Regex("""A\d*""").matches("A"))   // true  — ноль цифр тоже ок

            // ? : ноль или одно (необязательный символ)
            println(Regex("colou?r").matches("color"))  // true — 'u' отсутствует
            println(Regex("colou?r").matches("colour")) // true — 'u' есть

            // {n} : ровно n повторений
            println(Regex("""\d{4}""").matches("6342")) // true  — ровно 4 цифры
            println(Regex("""\d{4}""").matches("182"))  // false — только 3
        }
    }
}
