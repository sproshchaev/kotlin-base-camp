package com.prosoft.webinar14

import java.io.File

// Пример 9. Копирование файла — copyTo(overwrite = true)
class CopyFileDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val source = File("source.txt")
            source.writeText("важные данные")

            val target = File("copy.txt")

            // copyTo копирует файл. overwrite = true разрешает перезапись, если target уже есть.
            source.copyTo(target, overwrite = true)

            println("Копия существует? ${target.exists()}")
            println("Содержимое копии: ${target.readText()}")

            source.delete()
            target.delete()
        }
    }
}
