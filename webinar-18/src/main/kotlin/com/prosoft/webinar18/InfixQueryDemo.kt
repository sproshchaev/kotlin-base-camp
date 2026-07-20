package com.prosoft.webinar18

// Пример 4. Инфиксные функции.
// Как убрать точку и скобки из вызова, чтобы код читался как фраза.
//
// Классы Book и Library объявлены здесь и переиспользуются в примере 5
// (BookFilterSamDemo.kt) — файлы лежат в одном пакете.
data class Book(val title: String, val author: String, val year: Int)

class Library(private val books: List<Book>) {
    fun all(): List<Book> = books
}

// Три требования: расширение или метод, ровно один параметр,
// без vararg и без значений по умолчанию
infix fun Library.byAuthor(author: String): List<Book> =
    all().filter { it.author == author }

infix fun Int.addTo(x: Int): Int = this + x

class InfixQueryDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val library = Library(
                listOf(
                    Book("Война и мир", "Толстой", 1869),
                    Book("Анна Каренина", "Толстой", 1877),
                    Book("Чистый код", "Мартин", 2008)
                )
            )

            // Инфиксная форма — читается как фраза
            val tolstoy = library byAuthor "Толстой"
            println(tolstoy.map { it.title })     // [Война и мир, Анна Каренина]

            // Та же функция в обычной форме — результат идентичен
            println(library.byAuthor("Мартин").map { it.title })  // [Чистый код]

            // Приоритет: арифметика выполняется РАНЬШЕ инфиксного вызова
            println(1 addTo 2 + 3)      // 6  ->  1 addTo (2 + 3)
            println((1 addTo 2) + 3)    // 6  ->  явные скобки, тот же результат

            // Инфиксные функции стандартной библиотеки
            println("Hi" to "Kotlin")                          // (Hi, Kotlin)
            println(0x123456 shr 16)                           // 18
            println("Hi, Kotlin" matches ".*Kotlin".toRegex()) // true
        }
    }
}
