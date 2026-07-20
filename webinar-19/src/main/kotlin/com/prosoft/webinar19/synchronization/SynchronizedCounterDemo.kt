package com.prosoft.webinar19.synchronization

import kotlin.concurrent.thread

// Пример 9. Решение через @Synchronized и synchronized-блок.
// Аннотация @Synchronized защищает метод целиком, функция synchronized() —
// только выбранный фрагмент. Обе формы работают вокруг объекта-замка.

class SafeCounterByMethod {
    var count = 0

    @Synchronized
    fun inc() {
        count++
    }
}

class SafeCounterByBlock {
    var count = 0
    private val lock = Any()

    fun inc() {
        // незащищённая часть могла бы быть здесь
        synchronized(lock) {
            count++
        }
    }
}

class SynchronizedCounterDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val byMethod = SafeCounterByMethod()
            val byBlock = SafeCounterByBlock()

            val threads = List(10) {
                thread {
                    repeat(100_000) {
                        byMethod.inc()
                        byBlock.inc()
                    }
                }
            }
            threads.forEach { it.join() }

            println("@Synchronized:   ${byMethod.count}  (ожидали 1000000)")
            println("synchronized{}:  ${byBlock.count}  (ожидали 1000000)")
        }
    }
}
