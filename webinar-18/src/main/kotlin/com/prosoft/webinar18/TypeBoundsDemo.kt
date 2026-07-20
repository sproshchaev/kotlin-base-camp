package com.prosoft.webinar18

// Пример 10. Ограничения типов.
// Как сузить множество допустимых типов, чтобы внутри можно было обращаться к их свойствам.

open class Publication(val title: String, val year: Int)
class Magazine(title: String, year: Int) : Publication(title, year)
class Stone(val weight: Int)

interface Archivable { fun archiveCode(): String }

class Newspaper(title: String, year: Int) : Publication(title, year), Archivable {
    override fun archiveCode() = "NP-$year"
}

// Верхняя граница: подставить можно Publication или её подтип
class Storage<T : Publication> {
    private val items = mutableListOf<T>()
    fun add(item: T) { items.add(item) }
    // Благодаря границе компилятор знает про свойство year
    fun sortedByYear(): List<T> = items.sortedBy { it.year }
}

// Ограничение у функции — тот же синтаксис
fun <T : Publication> printTitles(items: List<T>) {
    items.forEach { println("  ${it.title} (${it.year})") }
}

// Несколько ограничений — через where
fun <T> archiveAll(items: List<T>)
    where T : Publication, T : Archivable {
    items.forEach { println("  ${it.title} -> ${it.archiveCode()}") }
}

class TypeBoundsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val storage = Storage<Magazine>()          // Magazine — подтип Publication, ОК
            storage.add(Magazine("Наука и жизнь", 2020))
            storage.add(Magazine("Вокруг света", 2015))
            println("Отсортировано по году:")
            printTitles(storage.sortedByYear())

            // val bad = Storage<Stone>()              // Type parameter Stone is not within its bounds
            // printTitles(listOf("строка"))           // String не подтип Publication

            println("Архивация:")
            archiveAll(
                listOf(
                    Newspaper("Известия", 2024),
                    Newspaper("Ведомости", 2023)
                )
            )
            // archiveAll(listOf(Magazine("Наука", 2020)))  // не проходит: нет Archivable
        }
    }
}
