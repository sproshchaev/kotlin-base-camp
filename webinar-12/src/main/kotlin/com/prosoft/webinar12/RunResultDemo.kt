package com.prosoft.webinar12

data class Service(var host: String = "", var port: Int = 0)

class RunResultDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // run НА объекте: настраиваем и возвращаем результат лямбды
            val url = Service().run {
                host = "localhost"
                port = 8080
                "http://$host:$port"     // последнее выражение -> результат
            }
            println(url)                 // http://localhost:8080

            // run БЕЗ объекта: просто сгруппировать строки и вернуть значение
            val hex = run {
                val digits = "0-9"
                val letters = "A-Fa-f"
                Regex("[$digits$letters]+")
            }
            println(hex.matches("1aF"))  // true
        }
    }
}
