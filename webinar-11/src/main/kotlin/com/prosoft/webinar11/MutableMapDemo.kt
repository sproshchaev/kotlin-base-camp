package com.prosoft.webinar11

class MutableMapDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val map = mutableMapOf("one" to 1, "two" to 2)

            map["three"] = 3        // добавление через []
            map.put("four", 4)      // добавление через put()
            println(map)            // {one=1, two=2, three=3, four=4}

            map["one"] = 100        // обновление по существующему ключу
            println(map["one"])     // 100

            map.remove("two")
            println(map)            // {one=100, three=3, four=4}

            println(map.keys)       // [one, three, four]
            println(map.values)     // [100, 3, 4]
        }
    }
}