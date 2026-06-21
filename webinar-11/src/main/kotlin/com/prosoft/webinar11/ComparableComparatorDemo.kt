package com.prosoft.webinar11

// естественный порядок задаётся через Comparable
data class Person(val name: String, val age: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int = this.age - other.age
}

class ComparableComparatorDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val people = listOf(
                Person("Alice", 25),
                Person("Bob", 30),
                Person("Charlie", 20)
            )

            // sorted() использует естественный порядок (по возрасту)
            println(people.sorted())
            // [Person(Charlie, 20), Person(Alice, 25), Person(Bob, 30)]

            // Comparator — кастомный порядок по имени
            val byName = Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) }
            println(people.sortedWith(byName))
            // [Alice, Bob, Charlie]

            // обратный порядок
            println(people.sortedWith(byName.reversed()))
            // [Charlie, Bob, Alice]
        }
    }
}