package com.prosoft.webinar19.basics

import kotlin.concurrent.thread

// Пример 3. Функция thread() и запуск.
// Один вызов вместо класса. Параметр start по умолчанию true —
// это отличает функцию от конструктора Thread.

class ThreadFunctionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val notStarted = thread(start = false, name = "Thread 4", block = {
                println("Hello, I'm ${Thread.currentThread().name}")
            })
            println("Создан, но не запущен. Alive: ${notStarted.isAlive}")
            notStarted.start()

            thread(name = "auto-started") {
                println("Hello, I'm ${Thread.currentThread().name}")
            }

            println("main дошёл до конца")
        }
    }
}
