package com.prosoft.webinar06

fun firstChar(s: String?): Char {
    val value = s ?: throw IllegalArgumentException("Строка пустая (null)")
    return value[0]   // value уже non-null
}

fun main() {
    println(firstChar("Kotlin"))   // K

    // firstChar(null)   // раскомментируй — выбросит исключение с понятным текстом
}