package com.prosoft.webinar06

fun describeIsbn(isbn: String?): String {
    if (isbn == null) return "ISBN отсутствует"
    // ниже компилятор уже знает: isbn — String, не String?
    return "Длина ${isbn.length}, префикс ${isbn.substring(0, 3)}"
}

fun main() {
    println(describeIsbn(null))             // ISBN отсутствует
    println(describeIsbn("9785916719892"))  // Длина 13, префикс 978
}