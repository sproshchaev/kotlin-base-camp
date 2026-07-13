package com.prosoft.webinar17

// Пример 1. Ленивое свойство by lazy — вычисление при первом обращении и кэширование.
class LazyStatsDemo {
    val heavyStat: String by lazy {
        println("  >> вычисляю heavyStat (дорогая операция)...")
        "результат дорогого вычисления"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val demo = LazyStatsDemo()
            println("Объект создан — лямбда ещё не запускалась")
            println("Первое обращение: ${demo.heavyStat}")
            println("Второе обращение: ${demo.heavyStat}")
        }
    }
}
