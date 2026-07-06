package com.prosoft.webinar15

// Пример 9. Захватывающие группы и MatchResult
class RegexGroupsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // группы в круглых скобках выделяют части шаблона
            val regex = Regex("""(\d{4})-(\d{2})-(\d{2})""")
            val match = regex.find("date: 2024-01-15")!!  // !! — уверены, что совпадение есть

            // value — всё совпадение; groupValues — совпадение + группы
            println(match.value)          // 2024-01-15
            println(match.groupValues)    // [2024-01-15, 2024, 01, 15]
            println(match.groupValues[1]) // 2024 (первая группа; индекс 0 — всё совпадение)
            println(match.range)          // 6..15 — позиция совпадения в строке

            // destructured — распаковка групп в переменные (число = числу групп)
            val (year, month, day) = match.destructured
            println("$day.$month.$year") // 15.01.2024
        }
    }
}
