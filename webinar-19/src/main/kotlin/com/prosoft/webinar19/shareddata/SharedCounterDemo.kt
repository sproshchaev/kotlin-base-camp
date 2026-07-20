package com.prosoft.webinar19.shareddata

// Пример 7. Общие данные: разделение объекта по ссылке.
// Потоки одного процесса делят кучу. Чтобы работать с одними данными,
// каждому нужна ссылка на один и тот же объект.

class Counter {
    var value = 0

    fun increment() {
        value++
    }
}

class IncrementingThread(private val counter: Counter, name: String) : Thread(name) {
    override fun run() {
        counter.increment()
        println("[$name] увеличил счётчик, текущее значение: ${counter.value}")
    }
}

class SharedCounterDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val counter = Counter()

            val thread1 = IncrementingThread(counter, "worker-1")
            val thread2 = IncrementingThread(counter, "worker-2")

            thread1.start()
            thread1.join()

            thread2.start()
            thread2.join()

            println("Итог: ${counter.value}")
        }
    }
}
