package com.prosoft.webinar12

class LetNullSafetyDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val name: String? = "Kotlin"
            val len: Int? = name?.let {
                println("not null: $it")   // выполнится — name не null
                it.length                   // последнее выражение -> результат
            }
            println(len)                 // 6

            val missing: String? = null
            val len2 = missing?.let { it.length }
            println(len2)                // null — блок пропущен
        }
    }
}
