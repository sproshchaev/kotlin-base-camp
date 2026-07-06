package com.prosoft.webinar14

import java.io.File

// Пример 3. Проверка существования и чтение целиком — exists() + readText()
class ReadTextDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val file = File("reading.txt")
            file.writeText("Kotlin or Java,\nJava or C++.")

            // Хороший тон — проверить существование перед чтением
            if (file.exists()) {
                val text = file.readText()   // весь файл в одну String
                print(text)
            } else {
                print("No such file")
            }

            file.delete()
        }
    }
}
