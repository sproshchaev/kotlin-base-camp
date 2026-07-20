package com.prosoft.webinar19.synchronization

import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

// Пример 13. AtomicInteger: мостик к домашнему заданию.
// Ту же проблему из примера 8 можно решить без блокировок — атомарным типом.
// Класс SafeCounterByMethod переиспользуется из примера 9
// (SynchronizedCounterDemo.kt) — тот же пакет.

class AtomicCounterDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val atomic = AtomicInteger(0)
            val synced = SafeCounterByMethod()

            var start = System.currentTimeMillis()
            List(10) { thread { repeat(500_000) { atomic.incrementAndGet() } } }
                .forEach { it.join() }
            val atomicTime = System.currentTimeMillis() - start

            start = System.currentTimeMillis()
            List(10) { thread { repeat(500_000) { synced.inc() } } }
                .forEach { it.join() }
            val syncedTime = System.currentTimeMillis() - start

            println("AtomicInteger:  ${atomic.get()}  за $atomicTime ms")
            println("@Synchronized:  ${synced.count}  за $syncedTime ms")
        }
    }
}
