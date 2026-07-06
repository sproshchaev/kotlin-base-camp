package com.prosoft.webinar14

import java.io.File

// Пример 5. Чтение больших файлов — forEachLine()
class ForEachLineDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val file = File("big.txt")
            file.writeText("строка 1\nстрока 2\nстрока 3")

            // forEachLine читает файл построчно, не держа его целиком в памяти
            file.forEachLine { line ->
                println("Прочитано: $line")
            }

            file.delete()
        }
    }
}
