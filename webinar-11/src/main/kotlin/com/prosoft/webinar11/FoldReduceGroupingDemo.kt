package com.prosoft.webinar11

class FoldReduceGroupingDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbers = listOf(1, 2, 3, 4, 5)

            // reduce — первый элемент становится начальным аккумулятором
            println(numbers.reduce { acc, x -> acc + x }) // 15

            // fold — задаём начальное значение сами (и можем сменить тип)
            println(numbers.fold(0) { acc, x -> acc + x })           // 15
            println(numbers.fold(1) { acc, x -> acc * x })           // 120
            val joined = listOf("a", "b", "c").fold("") { acc, s -> acc + s }
            println(joined) // abc

            // группировка
            val names = listOf("John", "Jane", "Mary", "Peter", "John")
            println(names.groupBy { it.first() })
            // {J=[John, Jane, John], M=[Mary], P=[Peter]}

            // группировка + подсчёт
            println(names.groupingBy { it.first() }.eachCount())
            // {J=3, M=1, P=1}
        }
    }
}