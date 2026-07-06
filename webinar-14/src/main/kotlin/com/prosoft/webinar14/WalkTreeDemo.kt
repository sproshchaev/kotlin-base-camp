package com.prosoft.webinar14

import java.io.File

// Пример 8. Обход дерева каталогов — walkTopDown()
class WalkTreeDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Готовим небольшое дерево: Files/Music/ и файл внутри
            val root = File("Files")
            root.resolve("Music").mkdirs()               // создаём вложенные каталоги сразу
            root.resolve("Music/track.txt").writeText("sound")
            root.resolve("readme.txt").writeText("hello")

            // walkTopDown — обход сверху вниз: сначала папка, потом её содержимое
            root.walkTopDown().forEach { println(it) }

            root.deleteRecursively() // убираем всё дерево целиком
        }
    }
}
