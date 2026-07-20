package com.prosoft.webinar19.safecollections

import kotlin.concurrent.thread

// Пример 12. StringBuilder против StringBuffer: поломка и цена.
// Сначала ломаем StringBuilder десятью потоками,
// потом измеряем, во сколько раз StringBuffer за это платит.

class StringBufferBenchmark {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Часть 1: потокобезопасность
            val builder = StringBuilder()
            val buffer = StringBuffer()

            val threads = List(10) {
                thread {
                    repeat(1000) {
                        builder.append("x")
                        buffer.append("x")
                    }
                }
            }
            threads.forEach { it.join() }

            println("StringBuilder: ожидали 10000, получили ${builder.length}")
            println("StringBuffer:  ожидали 10000, получили ${buffer.length}")

            // Часть 2: цена синхронизации
            val n = 50_000_000

            var start = System.currentTimeMillis()
            val b1 = StringBuffer()
            for (i in n downTo 1) b1.append("")
            val bufferTime = System.currentTimeMillis() - start

            start = System.currentTimeMillis()
            val b2 = StringBuilder()
            for (i in n downTo 1) b2.append("")
            val builderTime = System.currentTimeMillis() - start

            println("StringBuffer:  $bufferTime ms")
            println("StringBuilder: $builderTime ms")
        }
    }
}
