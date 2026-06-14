package com.prosoft.webinar08

class Cat(val name: String) {
    inner class Bow(val color: String) {
        fun printColor() {
            println("The cat named $name has a $color bow.")
        }
    }
}

fun main() {
    val cat = Cat("Bob")
    val bow = cat.Bow("red")  // от экземпляра Cat
    bow.printColor()          // The cat named Bob has a red bow.
}