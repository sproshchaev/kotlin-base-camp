package com.prosoft.webinar19.basics

// Пример 2. Два способа создать поток: Thread и Runnable.
// В обоих переопределяется run() — обычный метод, в который кладётся задача.

class HelloThread : Thread() {
    override fun run() {
        println("Hello, i'm $name")
    }
}

class HelloRunnable : Runnable {
    override fun run() {
        val threadName = Thread.currentThread().name
        println("Hello, i'm $threadName")
    }
}

class ThreadCreationBasics {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t1 = HelloThread()
            val t2 = Thread(HelloRunnable())
            val t3 = Thread(HelloRunnable(), "my-thread")
            val t4 = Thread {
                println("Hello, i'm ${Thread.currentThread().name}")
            }

            t1.start()
            t2.start()
            t3.start()
            t4.start()
        }
    }
}
