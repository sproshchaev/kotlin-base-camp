package com.prosoft.webinar12

fun square(x: Int) = x * x

class Greeter(val prefix: String) {
    fun greet(name: String) = "$prefix, $name!"
}

class FunctionReferenceDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val names = listOf("ann", "bob", "cat")

            // лямбда vs ссылка на функцию верхнего уровня — одинаковый результат
            println(listOf(1, 2, 3).map { square(it) })   // [1, 4, 9]
            println(listOf(1, 2, 3).map(::square))        // [1, 4, 9]

            // ссылка по классу: вызвать метод на каждом элементе
            println(names.map(String::uppercase))         // [ANN, BOB, CAT]

            // ссылка по объекту (bound) — привязана к конкретному g
            val g = Greeter("Hi")
            val greet = g::greet
            println(greet("Kotlin"))                      // Hi, Kotlin!
        }
    }
}
