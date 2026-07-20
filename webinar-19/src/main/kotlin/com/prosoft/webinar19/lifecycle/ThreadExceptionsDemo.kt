package com.prosoft.webinar19.lifecycle

import kotlin.concurrent.thread

// Пример 6. Исключения: три сценария.
// Исключение убивает поток, а не программу. Следим за кодом завершения процесса.

class FailingThread : Thread("failing-thread") {
    override fun run() {
        println("[$name] начал работу")
        println(2 / 0)
        println("[$name] эта строка не выполнится")
    }
}

class ThreadExceptionsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Сценарий 1: исключение в дочернем потоке
            val failing = FailingThread()
            failing.start()
            failing.join()
            println("I am printed! Процесс жив, exit code будет 0")

            // Сценарий 2: живой дочерний поток при падении main
            thread(name = "survivor") {
                Thread.sleep(200)
                println("[survivor] я отработал, несмотря на падение main")
            }

            Thread.sleep(50)
            println(2 / 0)          // main умирает здесь
            println("эта строка не выполнится")
        }
    }
}
