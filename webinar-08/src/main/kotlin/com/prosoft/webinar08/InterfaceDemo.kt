package com.prosoft.webinar08

interface Drawable {
    fun draw(): String
}

class Circle : Drawable {
    override fun draw(): String = "Рисую круг"
}

class Square : Drawable {
    override fun draw(): String = "Рисую квадрат"
}

fun main() {
    val shapes: List<Drawable> = listOf(Circle(), Square())
    for (shape in shapes) println(shape.draw())
}
// Рисую круг
// Рисую квадрат