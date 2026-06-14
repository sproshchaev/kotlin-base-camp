package com.prosoft.webinar09

class Player(val id: Int) {
    companion object {
        const val DEFAULT_SPEED = 7
        fun create(id: Int): Player = Player(id)
    }
}

fun main() {
    println(Player.DEFAULT_SPEED)        // 7 — без экземпляра
    val p = Player.create(13)            // фабричный метод
    println(p.id)                        // 13
}