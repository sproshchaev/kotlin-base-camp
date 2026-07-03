package com.prosoft.webinar13

// Пример 11. Тип Nothing: функция fail() и TODO
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun calculatePercentage(marks: Int, total: Int): Float {
    if (total == 0) {
        fail("total не может быть нулём")     // Nothing подходит вместо Float
    }
    return (marks / total.toFloat()) * 100
}

fun notReadyYet(): String {
    TODO("Ещё не реализовано")                // тоже Nothing
}

class NothingTodoDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(calculatePercentage(45, 50))      // 90.0
            println(calculatePercentage(1, 0))        // упадёт: IllegalStateException
            // notReadyYet()                           // упало бы: NotImplementedError
        }
    }
}
