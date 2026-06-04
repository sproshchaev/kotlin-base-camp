package com.prosoft.webinar04

import kotlin.math.abs

fun main() {
    val a = 0.1 + 0.2
    val b = 0.3
    println("a = $a")          // 0.30000000000000004
    println("b = $b")          // 0.3
    println("a == b ? ${a == b}")  // false

    val epsilon = 1e-9
    val areEqual = abs(a - b) < epsilon
    println("|a-b| < 1e-9 ? $areEqual")  // true
}