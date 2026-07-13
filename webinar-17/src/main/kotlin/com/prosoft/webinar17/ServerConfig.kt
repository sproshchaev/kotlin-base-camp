package com.prosoft.webinar17

// Пример 9. apply как мини-конфигуратор — компактный конфигурационный DSL.
data class ServerConfig(
    var host: String = "",
    var port: Int = 0,
    var useTls: Boolean = false
) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val config = serverConfig {
                host = "example.com"
                port = 443
                useTls = true
            }
            println(config)
        }
    }
}

fun serverConfig(init: ServerConfig.() -> Unit): ServerConfig =
    ServerConfig().apply(init)
