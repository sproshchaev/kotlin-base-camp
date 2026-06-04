package com.prosoft.webinar04

fun main() {
    val filename = "document.kotlin.txt"
    val nameWithoutExt = filename.substringBeforeLast('.')
    val extension = filename.substringAfterLast('.')
    println("Имя: $nameWithoutExt")   // document.kotlin
    println("Расширение: $extension") // txt

    val greeting = "Hello, Kotlin"
    println(greeting.substringAfter(','))  // " Kotlin"
    println(greeting.substringBefore(' ')) // "Hello,"
}