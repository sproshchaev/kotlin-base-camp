package com.prosoft.webinar08

object PlayingField {
    val maxPlayers = 4
    fun describe() = "Field for up to $maxPlayers players"
}

fun main() {
    println(PlayingField.describe())   // тот же объект отовсюду
    println(PlayingField.maxPlayers)   // 4
}