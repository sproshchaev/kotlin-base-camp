package com.prosoft.webinar18

// Пример 9. Обобщённые функции и функции-расширения.
// Как параметризовать не класс, а отдельную функцию — и объединить это с расширениями.

// Параметр типа объявляется ПЕРЕД именем функции
fun <T> firstOrDefault(list: List<T>, default: T): T =
    if (list.isEmpty()) default else list[0]

// Обобщённая функция-расширение: сначала <T>, потом тип получателя, потом имя
fun <T> List<T>.secondOrNull(): T? = if (size >= 2) this[1] else null

// Два параметра типа: вход и результат преобразования независимы
fun <T, R> List<T>.mapToSet(transform: (T) -> R): Set<R> {
    val result = mutableSetOf<R>()
    for (element in this) result.add(transform(element))
    return result
}

class GenericFunctionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbers = listOf(10, 20, 30)
            val names = listOf("Анна", "Борис")

            println(firstOrDefault(numbers, 0))          // 10
            println(firstOrDefault(emptyList(), -1))     // -1
            println(firstOrDefault(names, "нет"))        // Анна — одна функция, разные типы

            println(numbers.secondOrNull())              // 20
            println(listOf(1).secondOrNull())            // null

            // T = String, R = Int — типы выведены компилятором
            val lengths: Set<Int> = names.mapToSet { it.length }
            println(lengths)                             // [4, 5]

            // Результат сохраняет точный тип: Set<Int>, а не Set<Any>
            val doubled: Set<Int> = numbers.mapToSet { it * 2 }
            println(doubled)                             // [20, 40, 60]
        }
    }
}
