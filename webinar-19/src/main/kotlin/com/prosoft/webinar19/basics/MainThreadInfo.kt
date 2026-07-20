package com.prosoft.webinar19.basics

// Пример 1. Главный поток и его характеристики.
// Любая программа на Kotlin запускается в потоке main — его создаёт JVM.
// Получаем ссылку на этот поток и смотрим, что он о себе рассказывает.

class MainThreadInfo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t: Thread = Thread.currentThread()

            println("Name: ${t.name}")
            println("ID: ${t.id}")
            println("Alive: ${t.isAlive}")
            println("Priority: ${t.priority}")
            println("Daemon: ${t.isDaemon}")

            t.name = "my-thread"
            println("New name: ${t.name}")
        }
    }
}
