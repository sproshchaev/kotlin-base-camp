package com.prosoft.webinar15

// Пример 12. Практика: поиск телефонных номеров
class PhoneFinderDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // необязательные скобки \(? \)? и дефисы -? делают шаблон гибким
            val phoneRegex = Regex("""\(?\d{3}\)?-?\d{3}-?\d{4}""")

            val text = "звоните 123-345-6789 или (111)-234-5678, ещё 5551234567"

            // findAll находит все номера разных форматов
            for (match in phoneRegex.findAll(text)) {
                println(match.value) // 123-345-6789, (111)-234-5678, 5551234567
            }
        }
    }
}
