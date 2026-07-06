package com.prosoft.webinar14

import java.io.File

// Пример 1. Запись текста в файл — writeText()
class WriteTextDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Создаём объект File — это ТОЛЬКО ссылка на путь, файла на диске ещё нет
            val file = File("demo.txt")
            println("Файл существует до writeText? ${file.exists()}")   // false

            // writeText создаёт файл и записывает в него текст
            file.writeText("It is awfully hard work doing nothing!")
            println("Файл существует после writeText? ${file.exists()}") // true

            println("Содержимое: ${file.readText()}")

            file.delete() // убираем за собой
        }
    }
}
