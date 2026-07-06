package com.prosoft.webinar14

import java.io.File

// Пример 4. Чтение по строкам — readLines()
class ReadLinesDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val file = File("reading.txt")
            file.writeText("Kotlin or Java,\nJava or C++.")

            // readLines возвращает List<String> — каждая строка отдельным элементом
            val lines: List<String> = file.readLines()

            for (line in lines) {
                println(line)
            }
            println("Всего строк: ${lines.size}")

            file.delete()
        }
    }
}
