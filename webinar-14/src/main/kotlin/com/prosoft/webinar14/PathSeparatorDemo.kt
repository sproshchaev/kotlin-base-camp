package com.prosoft.webinar14

import java.io.File

// Пример 6. Кросс-платформенный путь — File.separator
class PathSeparatorDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Текущий рабочий каталог программы
            val workingDirectory = System.getProperty("user.dir")

            // Системный разделитель: \ на Windows, / на UNIX/macOS
            val separator = File.separator

            // Собираем путь из частей, не привязываясь к конкретной ОС
            val path = "${workingDirectory}${separator}myFile.txt"
            println("Разделитель этой ОС: '$separator'")
            println("Итоговый путь: $path")
        }
    }
}
