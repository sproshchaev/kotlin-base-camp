package com.prosoft.webinar15

// Пример 7. Поиск совпадений — find() и findAll()
class RegexFindDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = "born 1980-07-31 and later 1997-12-24"
            val dateRegex = Regex("""\d{4}-\d{2}-\d{2}""")

            // find() — первое совпадение; результат nullable, достаём через value
            val first = dateRegex.find(text)
            println(first?.value) // 1980-07-31

            // безопасная обработка отсутствия совпадения через Elvis
            val notFound = Regex("XYZ").find(text)?.value ?: "не найдено"
            println(notFound) // не найдено

            // findAll() — все совпадения сразу, перебираем циклом
            for (match in dateRegex.findAll(text)) {
                println(match.value) // 1980-07-31, затем 1997-12-24
            }
        }
    }
}
