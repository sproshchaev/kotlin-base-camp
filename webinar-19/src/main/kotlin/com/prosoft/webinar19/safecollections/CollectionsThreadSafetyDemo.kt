package com.prosoft.webinar19.safecollections

import java.util.concurrent.CopyOnWriteArrayList
import kotlin.concurrent.thread

// Пример 11. Коллекции: MutableList против конкурентных.
// Обычный MutableList теряет элементы при конкурентной записи.
// Сравниваем с CopyOnWriteArrayList из java.util.concurrent.

fun fill(target: MutableList<Int>, count: Int) {
    for (i in 0 until count) target += i
}

class CollectionsThreadSafetyDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val unsafe = mutableListOf<Int>()
            val safe = CopyOnWriteArrayList<Int>()

            val writers = List(4) {
                thread {
                    fill(unsafe, 25_000)
                    fill(safe, 25_000)
                }
            }
            writers.forEach { it.join() }

            println("MutableList:            ${unsafe.size}  (ожидали 100000)")
            println("CopyOnWriteArrayList:   ${safe.size}  (ожидали 100000)")
        }
    }
}
