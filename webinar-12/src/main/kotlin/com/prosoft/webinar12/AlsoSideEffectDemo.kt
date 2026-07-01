package com.prosoft.webinar12

class AlsoSideEffectDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = mutableListOf(1, 2, 3)
            nums.also { println("before add: $it") }   // before add: [1, 2, 3]
                .add(4)
            println(nums)                              // [1, 2, 3, 4]

            // обмен значений двух переменных в одну строку
            var a = 10
            var b = 5
            a = b.also { b = a }
            println("a=$a, b=$b")                      // a=5, b=10
        }
    }
}
