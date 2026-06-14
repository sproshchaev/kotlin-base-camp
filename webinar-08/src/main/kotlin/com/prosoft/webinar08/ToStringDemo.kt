package com.prosoft.webinar08

class User(val id: Int, val login: String) {
    override fun toString(): String {
        return "User{id=$id, login=$login}"
    }
}

fun main() {
    println(User(1, "uncle_bob"))  // User{id=1, login=uncle_bob}
}