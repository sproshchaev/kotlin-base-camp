package com.prosoft.webinar11

class FrequencyCounterDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val words = listOf("a", "b", "a", "c", "b", "a")
            val frequency = mutableMapOf<String, Int>()

            for (word in words) {
                val count = frequency[word] ?: 0   // если ключа нет — берём 0
                frequency[word] = count + 1
            }

            println(frequency) // {a=3, b=2, c=1}

            // группировка по первой букве -> списки
            val names = listOf("John", "Jane", "Mary", "Peter")
            val grouped = mutableMapOf<Char, MutableList<String>>()
            for (name in names) {
                grouped.getOrPut(name.first()) { mutableListOf() }.add(name)
            }
            println(grouped) // {J=[John, Jane], M=[Mary], P=[Peter]}
        }
    }
}