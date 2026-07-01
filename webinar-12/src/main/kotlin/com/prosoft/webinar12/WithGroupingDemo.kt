package com.prosoft.webinar12

class WithGroupingDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = listOf("first", "second", "third")

            // объект передаётся в скобках; внутри обращаемся к нему как к this
            val report = with(list) {
                "size=$size, first=${first()}, last=${last()}"
            }
            println(report)   // size=3, first=first, last=third
        }
    }
}
