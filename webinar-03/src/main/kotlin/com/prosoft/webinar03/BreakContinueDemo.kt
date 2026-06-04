package com.prosoft.webinar03

fun main() {
    println("Break при 3:")
    for (i in 1..5) {
        if (i == 3) break
        print("$i ")
    }

    println("\nContinue при 3:")
    for (i in 1..5) {
        if (i == 3) continue
        print("$i ")
    }
}