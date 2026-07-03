package com.prosoft.webinar13

import java.io.StringWriter

// Пример 10. use() — автоматическое закрытие ресурса
class UseResourceDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = StringWriter().use { writer ->
                writer.write("Строка 1\n")
                writer.write("Строка 2\n")
                writer.toString()                    // последнее выражение — результат use
            }
            print(text)
            // close() у writer уже вызван автоматически
        }
    }
}
