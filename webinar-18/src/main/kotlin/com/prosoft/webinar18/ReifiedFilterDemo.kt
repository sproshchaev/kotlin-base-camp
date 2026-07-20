package com.prosoft.webinar18

import kotlin.reflect.KClass

// Пример 12. inline и reified.
// Как обойти стирание типов и работать с параметром типа во время выполнения.

sealed class Media(val title: String)
class EBook(title: String) : Media(title)
class PrintedBook(title: String) : Media(title)
class AudioBook(title: String, val minutes: Int) : Media(title)

class MediaLibrary(private val items: List<Media>) {
    fun all(): List<Media> = items
}

// Без reified: тип стирается, приходится передавать класс параметром
@Suppress("UNCHECKED_CAST")
fun <T : Media> filterOld(items: List<Media>, clazz: KClass<T>): List<T> =
    items.filter { clazz.isInstance(it) } as List<T>

// С reified: тип доживает до выполнения, дополнительных параметров не нужно
inline fun <reified T : Media> MediaLibrary.ofType(): List<T> =
    all().filterIsInstance<T>()

inline fun <reified T> describeType() {
    println("Тип: ${T::class.simpleName}")
}

class ReifiedFilterDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val library = MediaLibrary(
                listOf(
                    EBook("Kotlin in Action"),
                    PrintedBook("Чистый код"),
                    EBook("Effective Kotlin"),
                    AudioBook("Война и мир", 2400)
                )
            )

            // Старый способ — тащим класс отдельным аргументом
            println(filterOld(library.all(), EBook::class).map { it.title })

            // Новый способ — тип выводится из объявления переменной
            val ebooks: List<EBook> = library.ofType()
            val printed: List<PrintedBook> = library.ofType()
            println(ebooks.map { it.title })      // [Kotlin in Action, Effective Kotlin]
            println(printed.map { it.title })     // [Чистый код]

            // Результат сохраняет точный тип — сразу доступны свойства подкласса
            val audio: List<AudioBook> = library.ofType()
            println(audio.map { "${it.title}: ${it.minutes} мин" })

            // T доступен как настоящий класс
            describeType<EBook>()                 // Тип: EBook
            describeType<String>()                // Тип: String
        }
    }
}
