package com.prosoft.webinar18

// Пример 8. Обобщённый класс.
// Зачем нужны угловые скобки, если есть Any — на живом сравнении.

// Обобщённый вариант: тип проходит через класс насквозь
class Box<T>(private val value: T) {
    fun get(): T = value
}

// Вариант с Any: принимает всё, но информацию о типе теряет
class AnyBox(private val value: Any) {
    fun get(): Any = value
}

// Несколько параметров типа — перечисляются через запятую
class Pair2<T, P>(var first: T, var second: P) {
    fun swap(): Pair2<P, T> = Pair2(second, first)
}

class TypedBoxDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stringBox = Box("abc")           // тип выведен компилятором
            val intBox: Box<Int> = Box(123)      // тип указан явно

            val str: String = stringBox.get()    // приведение НЕ требуется
            println("$str, ${intBox.get()}")     // abc, 123
            // val wrong: Int = stringBox.get()  // не компилируется — ошибка видна сразу

            val anyBox = AnyBox("abc")
            // val bad: String = anyBox.get()    // не компилируется: Type mismatch
            val forced: String = anyBox.get() as String   // нужен явный as
            println(forced)                                // abc

            // А вот цена такого подхода
            val trap = AnyBox(123)
            try {
                val boom: String = trap.get() as String    // компилируется, но падает
                println(boom)
            } catch (e: ClassCastException) {
                println("ClassCastException — ошибку увидел пользователь, а не разработчик")
            }

            val pair = Pair2("Kotlin", 2011)
            println("${pair.first} / ${pair.second}")                // Kotlin / 2011
            println("${pair.swap().first} / ${pair.swap().second}")  // 2011 / Kotlin
        }
    }
}
