package com.prosoft.webinar10

fun main() {
    val stars = arrayOf("Acrux", "Gacrux", "Imai")
    val extra = arrayOf("Ginan", "Mu Crucis")

    val all = stars + extra                  // конкатенация массивов
    println(all.joinToString())              // Acrux, Gacrux, Imai, Ginan, Mu Crucis

    val a = arrayOf("result", "is", "true")
    val b = arrayOf("result", "is", "true")

    println(a == b)                          // false — сравнивает ссылки!
    println(a.contentEquals(b))              // true  — сравнивает содержимое
}