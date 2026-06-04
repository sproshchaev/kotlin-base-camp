package com.prosoft.webinar04

fun main() {
    val input = "1000.0123456789"
    val d = input.toDouble()        // 1000.0123456789
    val f = d.toFloat()             // 1000.0123
    val i = f.toInt()               // 1000
    val b = i.toByte()              // -24 (переполнение!)

    println("Double: $d")
    println("Float:  $f")
    println("Int:    $i")
    println("Byte:   $b")
}