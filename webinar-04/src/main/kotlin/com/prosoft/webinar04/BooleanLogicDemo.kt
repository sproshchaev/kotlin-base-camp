package com.prosoft.webinar04

fun main() {
    val f = false
    val t = !f                     // true

    val and = true && false        // false
    val or  = true || false        // true
    val xor = true xor true        // false (отличие от ||)

    println("!false = $t")
    println("true && false = $and")
    println("true || false = $or")
    println("true xor true = $xor")
}