package com.prosoft.webinar06

fun main() {
    val obj: Any = "Hello, Kotlin"

    val str: String = obj as String        // ок: внутри строка
    println(str.uppercase())               // HELLO, KOTLIN

    val number: Any = 123
    val wrong: String? = number as? String // не строка → null, без падения
    println(wrong)                         // null

    // val crash = number as String        // раскомментируй — ClassCastException
}