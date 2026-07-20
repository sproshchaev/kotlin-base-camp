package com.prosoft.webinar18

// Пример 1. Функции-расширения.
// Как добавить метод к классу String, который мы не можем изменить, —
// без наследования и без обёрток.

// Тип получателя — String. Внутри this — та строка, на которой вызвали функцию
fun String.repeated(): String = this + this

// Расширение с обращением к методам получателя напрямую (без this)
fun String.initials(): String =
    split(" ")
        .filter { it.isNotEmpty() }
        .joinToString(".") { it.first().uppercase() }

class Client(val name: String, val age: Int)

// Расширение для собственного класса — доступ к полям напрямую, без this
fun Client.getInfo() = "$name, $age лет"

class StringExtensionsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("ha".repeated())                     // haha
            println("лев николаевич толстой".initials())  // Л.Н.Т

            val client = Client("John", 32)
            println(client.getInfo())                     // John, 32 лет
        }
    }
}
