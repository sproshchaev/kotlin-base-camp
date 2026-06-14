package com.prosoft.webinar08

open class Shape {
    open val vertexCount: Int = 0
}

class Triangle : Shape() {
    override val vertexCount: Int = 3
}

fun main() {
    val shape: Shape = Triangle()
    println("Вершин: ${shape.vertexCount}")  // сработает значение потомка
}
// Вершин: 3