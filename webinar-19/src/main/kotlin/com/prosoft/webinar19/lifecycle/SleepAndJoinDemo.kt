package com.prosoft.webinar19.lifecycle

import java.util.concurrent.TimeUnit

// Пример 5. Управление временем: sleep и join.
// sleep усыпляет тот поток, в котором вызван.
// join вызывается на чужом объекте, а останавливает текущий поток.

class SlowWorker : Thread("slow-worker") {
    override fun run() {
        println("[${name}] Starting a task")
        sleep(2000)
        println("[${name}] The task is finished")
    }
}

class SleepAndJoinDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Started")
            TimeUnit.SECONDS.sleep(1)
            println("Прошла секунда")

            val worker = SlowWorker()
            worker.start()

            Thread.sleep(100)
            println("[main] Do something useful")

            worker.join(3000)
            println("[main] The program stopped")
        }
    }
}
