package com.prosoft.webinar13

// Пример 4. Несколько блоков catch, порядок «от частного к общему»
class MultipleCatchDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = "abc"                        // поменяйте на "0", чтобы увидеть другой catch
            try {
                println(100 / input.toInt())
            } catch (e: NumberFormatException) {     // специфичное — выше
                println("You didn't type an INT number!")
            } catch (e: ArithmeticException) {
                println("You typed 0!")
            } catch (e: Exception) {                 // общее — ниже
                println("What else can go wrong!")
            }
        }
    }
}
