package com.prosoft.webinar03

fun main() {
    // return
    fun findFirstPositive(list: List<Int>): Int? {
        for (x in list) {
            if (x > 0) return x
        }
        return null
    }
    println(findFirstPositive(listOf(-1, -2, 3, 4))) // 3

    // метка
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2) break@outer
            println("($i, $j)")
        }
    }
}