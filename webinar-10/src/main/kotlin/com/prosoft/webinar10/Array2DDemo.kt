package com.prosoft.webinar10

fun main() {
    val matrix = arrayOf(
        arrayOf(0, 1, 2),
        arrayOf(3, 4, 5)
    )

    println(matrix[0][0])    // 0 — первая строка, первый столбец
    println(matrix[1][2])    // 5 — вторая строка, третий столбец

    matrix[0][1] = 99        // меняем элемент по двум индексам
    println(matrix[0][1])    // 99

    // вывод всего содержимого одной строкой
    println(matrix.contentDeepToString())  // [[0, 99, 2], [3, 4, 5]]
}