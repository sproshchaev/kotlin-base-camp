package com.prosoft.webinar18

// Пример 5. SAM-интерфейсы и лямбды.
// Как интерфейс с одним методом создаётся лямбдой — без анонимного класса.
//
// Класс Book переиспользуется из примера 4 (InfixQueryDemo.kt) — тот же пакет.

// Ключевое слово fun перед interface — включает SAM-преобразование
fun interface BookFilter {
    fun matches(book: Book): Boolean
}

class Catalog(private val books: List<Book>) {
    fun filter(filter: BookFilter): List<Book> = books.filter { filter.matches(it) }
}

class BookFilterSamDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val catalog = Catalog(
                listOf(
                    Book("Война и мир", "Толстой", 1869),
                    Book("Чистый код", "Мартин", 2008),
                    Book("Kotlin in Action", "Жемеров", 2017)
                )
            )

            // Так выглядела бы реализация БЕЗ SAM-преобразования
            val oldStyle = object : BookFilter {
                override fun matches(book: Book): Boolean = book.year > 2000
            }
            println(catalog.filter(oldStyle).size)    // 2

            // А так — с ним. Одна строка вместо трёх
            val modern: BookFilter = BookFilter { it.year > 2000 }
            println(catalog.filter(modern).size)      // 2

            // И совсем коротко — лямбда прямо в вызове
            println(catalog.filter { it.author == "Толстой" }.map { it.title })

            // Функциональный интерфейс из стандартной библиотеки
            val byYear: Comparator<Book> = Comparator { a, b -> a.year - b.year }
            println(catalog.filter { true }.sortedWith(byYear).map { it.year })  // [1869, 2008, 2017]
        }
    }
}
