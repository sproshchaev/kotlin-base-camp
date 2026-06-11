package com.prosoft.webinar06

fun main() {
    val name: String? = "Kotlin"
    println(name!!.length)   // 6 — мы уверены, что не null

    val empty: String? = null
    // println(empty!!.length)  // NullPointerException — упадёт здесь
}