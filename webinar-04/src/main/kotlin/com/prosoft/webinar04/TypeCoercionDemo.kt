package com.prosoft.webinar04

fun main() {
    val intNum: Int = 100
    val longNum: Long = 1000
    val result1 = intNum + longNum          // тип Long
    println("Int + Long = $result1 (тип ${result1::class.simpleName})")

    val bigLong: Long = 100_000
    val doubleNum: Double = 0.0
    val result2 = bigLong - doubleNum       // тип Double
    println("Long - Double = $result2 (тип ${result2::class.simpleName})")
}