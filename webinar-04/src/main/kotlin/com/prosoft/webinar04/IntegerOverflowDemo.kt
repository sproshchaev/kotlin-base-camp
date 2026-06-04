package com.prosoft.webinar04

fun main() {
    var maxInt = Int.MAX_VALUE
    println("Max Int: $maxInt")
    maxInt += 1
    println("After +1: $maxInt")   // -2147483648

    val largeLong = 1_000_000_000_000_000
    val fromLong = largeLong.toInt()
    println("Long $largeLong -> Int $fromLong")  // -1530494976
}