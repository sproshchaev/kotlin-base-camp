package com.prosoft.webinar15

// Пример 10. Именованные группы
class RegexNamedGroupsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // именованные группы: (?<name>...) вместо номеров
            val regex = Regex("""(?<year>\d{4})-(?<month>\d{2})-(?<day>\d{2})""")
            val match = regex.find("2023-12-31")!!

            // обращение по имени через groups["имя"]
            println(match.groups["year"]?.value)  // 2023
            println(match.groups["month"]?.value) // 12
            println(match.groups["day"]?.value)   // 31

            // доступ по индексу тоже работает: 0 — всё совпадение, группы с 1
            println(match.groups[1]?.value)       // 2023 — то же, что groups["year"]
        }
    }
}
