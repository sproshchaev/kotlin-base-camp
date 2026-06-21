package com.prosoft.webinar11

class MutableCollectionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val songs = mutableSetOf("Creep", "Street Spirit")

            songs.add("Spectre")
            println(songs) // [Creep, Street Spirit, Spectre]

            songs.addAll(listOf("Lucky", "No Surprises"))
            println(songs) // [Creep, Street Spirit, Spectre, Lucky, No Surprises]

            val removed = songs.remove("Creep")
            println(removed) // true
            println(songs)   // [Street Spirit, Spectre, Lucky, No Surprises]

            // оставить только пересечение
            songs.retainAll(listOf("Spectre", "Lucky"))
            println(songs) // [Spectre, Lucky]

            println(songs.remove("Creep")) // false — элемента уже нет
        }
    }
}