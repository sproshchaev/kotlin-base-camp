package com.prosoft.webinar19.shareddata

import kotlin.concurrent.thread

// Пример 10. @Volatile и проблема видимости.
// Второй поток может вообще не увидеть записанное значение.
// Бесконечный цикл не останавливается, хотя флаг давно выставлен.

class StoppableWorker {
    var stop: Boolean = false          // попробуйте добавить @Volatile

    fun launch() {
        thread(name = "spinner") {
            var iterations = 0L
            while (!stop) {
                iterations++
            }
            println("[spinner] остановлен после $iterations итераций")
        }
    }
}

class VolatileVisibilityDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val worker = StoppableWorker()
            worker.launch()

            Thread.sleep(100)
            worker.stop = true
            println("[main] флаг выставлен: stop = ${worker.stop}")

            Thread.sleep(1000)
            println("[main] завершаюсь; spinner может всё ещё крутиться")
        }
    }
}
