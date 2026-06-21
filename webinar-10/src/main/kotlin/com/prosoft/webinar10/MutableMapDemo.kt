package com.prosoft.webinar10

import kotlin.collections.iterator

fun main() {
    val staff = mutableMapOf("John" to 500, "Mike" to 1000)

    staff["Nika"] = 999      // добавили пару (put)
    staff["John"] = 700      // ключ существует — значение перезаписано
    staff.remove("Mike")     // удалили по ключу

    for ((name, salary) in staff) {
        println("$name -> $salary")
    }
    // John -> 700
    // Nika -> 999
}