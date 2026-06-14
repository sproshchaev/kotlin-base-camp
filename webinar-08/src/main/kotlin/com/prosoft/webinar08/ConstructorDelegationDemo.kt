package com.prosoft.webinar08

open class Figure(val name: String)

class Rectangle : Figure {
    val width: Int
    val height: Int

    // основной вторичный конструктор: вызывает конструктор родителя через super
    constructor(width: Int, height: Int) : super("Прямоугольник") {
        this.width = width
        this.height = height
    }

    // удобный конструктор для квадрата: делегирует своему же через this
    constructor(side: Int) : this(side, side)
}

fun main() {
    val rect = Rectangle(3, 5)
    val square = Rectangle(4)
    println("${rect.name}: ${rect.width}x${rect.height}")
    println("${square.name}: ${square.width}x${square.height}")
}
// Прямоугольник: 3x5
// Прямоугольник: 4x4