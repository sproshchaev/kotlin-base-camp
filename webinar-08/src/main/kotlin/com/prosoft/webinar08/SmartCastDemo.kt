package com.prosoft.webinar08.shape

open class Shape
class Circle(val radius: Int) : Shape()
class Rectangle(val width: Int, val height: Int) : Shape()

fun area(shape: Shape): Int = when (shape) {
    is Circle -> 3 * shape.radius * shape.radius      // shape уже Circle
    is Rectangle -> shape.width * shape.height         // shape уже Rectangle
    else -> 0
}

fun main() {
    println(area(Circle(5)))
    println(area(Rectangle(3, 4)))
}
// 75
// 12