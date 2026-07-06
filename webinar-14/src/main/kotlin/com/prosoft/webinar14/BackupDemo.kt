package com.prosoft.webinar14

import java.io.File

// Пример 12. Резервная копия перед перезаписью (сборка изученного)
class BackupDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val file = File("report.txt")
            file.writeText("Отчёт, версия 1")   // исходная версия

            // Перед перезаписью — делаем backup, если файл уже существует
            if (file.exists()) {
                val backupDir = File("backups")
                backupDir.mkdirs()                                  // создаём папку для копий

                val timestamp = System.currentTimeMillis()          // уникальная метка времени
                val backup = backupDir.resolve("report-$timestamp.txt")

                file.copyTo(backup, overwrite = false)               // копируем старую версию
                println("Сделан backup: ${backup.name}")
            }

            file.writeText("Отчёт, версия 2")   // теперь записываем новые данные
            println("Файл перезаписан. Текущее содержимое: ${file.readText()}")

            // убираем за собой
            file.delete()
            File("backups").deleteRecursively()
        }
    }
}
