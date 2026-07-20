package com.prosoft.webinar18

// Пример 7. equals, hashCode и data class.
// Почему два метода переопределяются только вместе и как data class делает это за нас.

// Без переопределения — сравнение по ссылкам
class PersonNaive(val name: String, val age: Int)

// Ручная реализация обоих методов
class Person(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true          // тот же объект
        if (other !is Person) return false       // не тот тип
        if (name != other.name) return false     // умное приведение: other уже Person
        return age == other.age
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age.hashCode()    // стандартный приём комбинирования
        return result
    }
}

// Компилятор сгенерирует equals и hashCode сам
data class PersonData(val name: String, val age: Int)

class PersonEqualityDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("--- Без переопределения ---")
            println(PersonNaive("John", 32) == PersonNaive("John", 32))   // false!

            println("--- Ручная реализация ---")
            val p1 = Person("John", 32)
            val p2 = Person("John", 32)
            val p3 = Person("John", 64)
            println(p1 == p2)                              // true
            println(p1 == p3)                              // false
            println(p1.hashCode() == p2.hashCode())        // true

            println("--- data class ---")
            val d1 = PersonData("John", 32)
            val d2 = PersonData("John", 32)
            println(d1 == d2)                              // true
            println(d1.hashCode() == d2.hashCode())        // true

            println("--- Зачем нужен контракт ---")
            val set = hashSetOf(PersonData("John", 32))
            println(PersonData("John", 32) in set)         // true — hashCode согласован с equals
            val brokenSet = hashSetOf(PersonNaive("John", 32))
            println(PersonNaive("John", 32) in brokenSet)  // false — объект «потерялся»
        }
    }
}
