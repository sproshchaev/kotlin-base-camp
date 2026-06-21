package com.prosoft.webinar11

class MutableIteratorDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val colors = mutableListOf("red", "green", "blue", "white")
            val iterator = colors.listIterator()

            iterator.next()        // red
            iterator.remove()      // удаляем red
            println(colors)        // [green, blue, white]

            iterator.next()        // green
            iterator.set("lime")   // заменяем green -> lime
            println(colors)        // [lime, blue, white]

            iterator.add("black")  // добавляем после lime
            println(colors)        // [lime, black, blue, white]
        }
    }
}