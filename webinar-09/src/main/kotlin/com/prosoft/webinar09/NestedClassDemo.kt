package com.prosoft.webinar09

class Superhero {
    val power = 1000

    class Hammer {
        val mightPower = 100   // доступа к power нет
    }
}

fun main() {
    val hammer = Superhero.Hammer()  // внешний экземпляр не нужен
    println(hammer.mightPower)       // 100
}