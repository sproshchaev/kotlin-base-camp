package com.prosoft.webinar11

// связный список сообщений
class Message(var text: String, var next: Message? = null)

class MessageBox(var head: Message, var tail: Message = head) : Iterable<Message> {
    init {
        if (tail != head) head.next = tail
    }

    fun add(newMessage: Message) {
        tail.next = newMessage
        tail = newMessage
    }

    override fun iterator(): Iterator<Message> = MessageBoxIterator(this)
}

class MessageBoxIterator(messageBox: MessageBox) : Iterator<Message> {
    private var current: Message = Message("PRE_HEAD", next = messageBox.head)

    override fun hasNext(): Boolean = current.next != null

    override fun next(): Message {
        if (current.next == null) throw NoSuchElementException()
        current = current.next!!
        return current
    }
}

class CustomIterableDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val box = MessageBox(Message("hello!"))
            box.add(Message("I am from the webinar"))
            box.add(Message("which language do you study?"))

            // наш класс работает в обычном for, потому что реализует Iterable
            for (message in box) {
                println(message.text)
            }
            // hello!
            // I am from the webinar
            // which language do you study?
        }
    }
}