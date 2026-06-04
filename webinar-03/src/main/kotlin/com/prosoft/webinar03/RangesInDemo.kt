package com.prosoft.webinar03

fun main() {
    val x = 5
    println(x in 1..5)      // true
    println(x in 1 until 5) // false (5 не входит)
    println(x in 1..<5)     // то же, что until (синтаксис 1.7.20+)

    val c = 'b'
    println(c in 'a'..'c')  // true

    val range = 100..200
    println(300 in range)   // false
}