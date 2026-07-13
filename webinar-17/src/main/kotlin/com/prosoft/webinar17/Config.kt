package com.prosoft.webinar17

// Пример 5. Свойства из Map — свойство читается по своему имени как по ключу.
class Config(val map: Map<String, Any?>) {
    val host: String by map
    val port: Int by map
    val debug: Boolean by map

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val config = Config(mapOf(
                "host" to "localhost",
                "port" to 8080,
                "debug" to true
            ))
            println("host  = ${config.host}")
            println("port  = ${config.port}")
            println("debug = ${config.debug}")
        }
    }
}
