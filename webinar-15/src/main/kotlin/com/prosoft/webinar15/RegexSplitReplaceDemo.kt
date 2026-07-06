package com.prosoft.webinar15

// Пример 8. Split и Replace по регулярному выражению
class RegexSplitReplaceDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // split по regex: разделителем может быть любой пробельный символ
            val messy = "one   two\tthree\nfour"
            println(messy.split(Regex("""\s+"""))) // [one, two, three, four]

            // replace по regex: заменяем ВСЕ числа на заглушку
            val text = "Falcon 9 launched in 2010"
            println(text.replace(Regex("""\d+"""), "[num]")) // Falcon [num] launched in [num]

            // replace с лямбдой: трансформируем каждое совпадение
            val highlighted = text.replace(Regex("""\d+""")) { m -> "<${m.value}>" }
            println(highlighted) // Falcon <9> launched in <2010>
        }
    }
}
