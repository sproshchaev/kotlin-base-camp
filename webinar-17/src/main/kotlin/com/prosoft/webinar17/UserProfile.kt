package com.prosoft.webinar17

import kotlin.properties.Delegates

// Пример 3. Delegates.observable — реакция на каждое изменение свойства.
class UserProfile {
    var status: String by Delegates.observable("offline") { prop, old, new ->
        println("  [${prop.name}] изменился: $old -> $new")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val user = UserProfile()
            println("Меняем статус...")
            user.status = "online"
            user.status = "away"
            user.status = "offline"
        }
    }
}
