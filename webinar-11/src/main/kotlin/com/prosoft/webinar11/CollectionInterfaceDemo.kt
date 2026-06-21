package com.prosoft.webinar11

class CollectionInterfaceDemo {
    companion object {
        // принимает любую неизменяемую коллекцию строк
        fun printAll(items: Collection<String>) {
            items.forEach { print("$it ") }
            println()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val listOfSongs = listOf("Creep", "Idioteque", "Street Spirit")
            val setOfSongs = setOf("Creep", "Idioteque", "Street Spirit")

            printAll(listOfSongs) // Creep Idioteque Street Spirit
            printAll(setOfSongs)  // Creep Idioteque Street Spirit

            // общие методы Collection
            println(listOfSongs.count { it.contains("e") }) // 3
            println(listOfSongs.drop(1))                    // [Idioteque, Street Spirit]
        }
    }
}