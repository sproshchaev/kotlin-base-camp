package com.prosoft.webinar06

fun main() {
    val name: String? = "Kotlin"

    // println(name.length)   // не скомпилируется: name может быть null

    if (name != null) {
        println(name.length)   // 6 — внутри проверки доступ разрешён
    }
}