package com.prosoft.webinar08

class Service {
    lateinit var config: String

    fun init(value: String) { config = value }

    fun show() {
        if (::config.isInitialized) println("Config: $config")
        else println("Config ещё не задан")
    }
}

fun main() {
    val s = Service()
    s.show()             // Config ещё не задан
    s.init("prod")
    s.show()             // Config: prod
}