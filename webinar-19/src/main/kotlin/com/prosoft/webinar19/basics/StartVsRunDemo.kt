package com.prosoft.webinar19.basics

// Пример 4. start() против run() и непредсказуемость порядка.
// Вызвать run() вместо start() — частая ошибка: код отработает,
// но никакой многопоточности не будет.

class NamedWorker(private val label: String) : Thread(label) {
    override fun run() {
        println("$label выполняется в потоке: ${currentThread().name}")
    }
}

class StartVsRunDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("--- прямой вызов run() ---")
            NamedWorker("worker-A").run()

            println("--- вызов start() ---")
            NamedWorker("worker-B").start()

            Thread.sleep(100)

            println("--- порядок между потоками ---")
            val t1 = NamedWorker("worker-1")
            val t2 = NamedWorker("worker-2")
            t1.start()
            t2.start()
            println("Finished")
        }
    }
}
