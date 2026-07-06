package com.prosoft.webinar14

import java.io.File

// Пример 7. Создание файла и каталога — mkdir() / resolve() / createNewFile()
class CreateFileDirDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val dir = File("outDir")
            println("Каталог существует? ${dir.exists()}")   // false
            dir.mkdir()                                       // создаём каталог
            println("Это каталог? ${dir.isDirectory}")        // true

            // resolve строит путь к файлу ВНУТРИ каталога: outDir/newFile.txt
            val file = dir.resolve("newFile.txt")
            println("Файл существует? ${file.exists()}")      // false
            file.createNewFile()                              // создаём пустой файл
            println("Это файл? ${file.isFile}")               // true

            // убираем за собой: сначала файл, потом каталог
            file.delete()
            dir.delete()
        }
    }
}
