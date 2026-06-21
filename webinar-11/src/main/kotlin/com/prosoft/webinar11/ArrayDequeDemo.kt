package com.prosoft.webinar11

class ArrayDequeDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val deque = ArrayDeque<Int>()

            // как ОЧЕРЕДЬ (FIFO): добавляем в конец, удаляем из начала
            deque.addLast(1)
            deque.addLast(2)
            deque.addLast(3)
            println(deque)          // [1, 2, 3]
            println(deque.removeFirst()) // 1
            println(deque)          // [2, 3]

            // как СТЕК (LIFO): добавляем и удаляем с одного конца
            deque.addLast(4)
            println(deque)          // [2, 3, 4]
            println(deque.removeLast()) // 4
            println(deque)          // [2, 3]

            // доступ к краям без удаления
            println(deque.first())  // 2
            println(deque.last())   // 3
        }
    }
}