package com.prosoft.webinar18

// Пример 2. Приоритет члена класса над расширением.
// Что произойдёт, если объявить расширение с той же сигнатурой, что и метод класса.

class Greeter {
    fun greet() = println("Привет из метода класса")
}

// Сигнатура полностью совпадает с методом класса — код компилируется,
// но это расширение никогда не будет вызвано (мёртвый код)
fun Greeter.greet() = println("Привет из расширения")

// А вот с другой сигнатурой конфликта нет
fun Greeter.greet(name: String) = println("Привет, $name, из расширения")

class MemberVsExtensionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val greeter = Greeter()

            greeter.greet()          // Привет из метода класса — победил член класса
            greeter.greet("Мария")   // Привет, Мария, из расширения — другая сигнатура
        }
    }
}
