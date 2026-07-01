package com.prosoft.webinar12

// init — лямбда с получателем: выполнится в контексте StringBuilder
fun myString(init: StringBuilder.() -> Unit): String =
    StringBuilder().apply(init).toString()

class LambdaWithReceiverDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = myString {
                append("Hello, ".uppercase())   // append вызывается на StringBuilder — он получатель
                append("World!")
            }
            println(text)   // HELLO, World!
        }
    }
}
