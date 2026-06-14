package com.prosoft.webinar09

fun minMax(nums: List<Int>): Pair<Int, Int> = Pair(nums.min(), nums.max())

fun main() {
    val (lo, hi) = minMax(listOf(3, 7, 1, 9))  // деструктуризация
    println("min=$lo, max=$hi")

    val triple = Triple(1, "A", true)
    println(triple.toList())   // [1, A, true]

    val pair = 1 to "one"      // инфиксная функция to
    println(pair)              // (1, one)
}