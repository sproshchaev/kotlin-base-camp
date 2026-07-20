package com.prosoft.webinar19.shareddata

import kotlin.concurrent.thread

// Пример 8. Race condition: как теряются данные.
// Два потока, десять миллионов инкрементов каждый — ждём двадцать миллионов.
// Запускаем трижды и смотрим, сколько получится на самом деле.

class UnsafeCounter {
    var count = 0

    fun inc() {
        count++      // НЕ атомарно: read → +1 → write
    }
}

class RaceConditionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val counter = UnsafeCounter()

            val t1 = thread { repeat(10_000_000) { counter.inc() } }
            val t2 = thread { repeat(10_000_000) { counter.inc() } }

            t1.join()
            t2.join()

            println("Ожидали: 20000000")
            println("Получили: ${counter.count}")
            println("Потеряно: ${20_000_000 - counter.count}")
        }
    }
}
