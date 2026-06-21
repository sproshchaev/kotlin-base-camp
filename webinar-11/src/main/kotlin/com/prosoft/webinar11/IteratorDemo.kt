package com.prosoft.webinar11

class IteratorDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val animals = setOf("cat", "dog", "crocodile", "snake")
            val iterator = animals.iterator()

            while (iterator.hasNext()) {
                print(iterator.next() + " ") // cat dog crocodile snake
            }
            println()

            // итератор исчерпан — для повторного прохода нужен новый
            println(iterator.hasNext()) // false

            val newIterator = animals.iterator()
            println(newIterator.next()) // cat
        }
    }
}