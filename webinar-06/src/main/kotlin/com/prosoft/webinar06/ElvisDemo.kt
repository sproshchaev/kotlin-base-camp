package com.prosoft.webinar06

fun main() {
    val name: String? = null

    val length: Int = name?.length ?: 0
    println(length)   // 0 — name пустой, подставилось значение по умолчанию

    val name2: String? = "Kotlin"
    println(name2?.length ?: 0)   // 6 — значение есть, Элвис не нужен
}