package com.prosoft.webinar12

class Person(val firstName: String, val age: Int) {
    override fun toString() = "Person(firstName=$firstName, age=$age)"
}

class PersonBuilder {
    var firstName: String = ""
    var age: Int = 0
    fun build() = Person(firstName, age)
}

// функция-строитель принимает лямбду с получателем PersonBuilder
fun person(init: PersonBuilder.() -> Unit): Person {
    val builder = PersonBuilder()
    builder.init()           // выполняем переданный блок в контексте builder
    return builder.build()
}

class BuilderDslDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val p = person {
                firstName = "John"   // это builder.firstName — получатель
                age = 30             // это builder.age
            }
            println(p)   // Person(firstName=John, age=30)
        }
    }
}
