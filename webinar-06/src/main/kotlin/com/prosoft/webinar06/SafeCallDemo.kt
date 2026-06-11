package com.prosoft.webinar06

fun main() {
    val name: String? = "Kotlin"
    val empty: String? = null

    println(name?.length)    // 6
    println(empty?.length)   // null — не падает
}