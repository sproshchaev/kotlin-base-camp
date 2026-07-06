package com.prosoft.webinar14

import kotlin.io.path.Path
import kotlin.io.path.writeText
import kotlin.io.path.readText
import kotlin.io.path.readLines
import kotlin.io.path.exists
import kotlin.io.path.deleteIfExists

// Пример 11. Современный API — объект Path
class PathApiDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val path = Path("path-demo.txt")

            // Запись и чтение — те же операции, что у File, но вызываются у Path
            path.writeText("строка A\nстрока B")

            println("Существует? ${path.exists()}")
            println("Весь текст: ${path.readText()}")

            val lines = path.readLines()   // List<String>
            println("Строк: ${lines.size}")

            path.deleteIfExists() // убираем за собой
        }
    }
}
