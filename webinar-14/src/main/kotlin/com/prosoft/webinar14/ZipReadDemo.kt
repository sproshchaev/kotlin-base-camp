package com.prosoft.webinar14

import java.io.File
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream
import java.util.zip.ZipEntry
import java.io.FileOutputStream

// Пример 10. Чтение ZIP-архива — ZipFile + use + entries()
class ZipReadDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Сначала подготовим небольшой архив с двумя записями
            val zipPath = File("demo.zip")
            ZipOutputStream(FileOutputStream(zipPath)).use { zip ->
                zip.putNextEntry(ZipEntry("readme.txt"))
                zip.write("hello".toByteArray())
                zip.closeEntry()
                zip.putNextEntry(ZipEntry("data.txt"))
                zip.write("42".toByteArray())
                zip.closeEntry()
            }

            // Читаем архив: ZipFile + use гарантирует закрытие, entries() даёт все записи
            ZipFile(zipPath).use { zipFile ->
                val entries = zipFile.entries()
                while (entries.hasMoreElements()) {
                    val entry = entries.nextElement()
                    println("Запись в архиве: ${entry.name}")
                }
            }

            zipPath.delete()
        }
    }
}
