package com.prosoft.webinar17

import kotlin.properties.Delegates

// Пример 4. Delegates.vetoable — валидация нового значения перед присваиванием.
class GameScore {
    var points: Int by Delegates.vetoable(0) { _, old, new ->
        val accepted = new >= old
        if (!accepted) println("  отклонено: $new меньше текущего $old")
        accepted
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val score = GameScore()
            score.points = 10
            println("Очки: ${score.points}")
            score.points = 25
            println("Очки: ${score.points}")
            score.points = 5   // будет отклонено
            println("Очки: ${score.points}")
        }
    }
}
