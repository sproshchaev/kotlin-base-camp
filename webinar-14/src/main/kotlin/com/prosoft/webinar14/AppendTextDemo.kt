package com.prosoft.webinar14

import java.io.File

// Пример 2. Дозапись в конец — appendText()
class AppendTextDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val file = File("quote.txt")

            // writeText — записывает содержимое с нуля (перезапись)
            file.writeText("Beware of bugs in the above code; I have only proved it correct, not tried it")

            // appendText — НЕ стирает, а дописывает в конец
            file.appendText(", Donald E. Knuth said.")

            println(file.readText())
            // Beware of bugs...correct, not tried it, Donald E. Knuth said.

            file.delete()
        }
    }
}
