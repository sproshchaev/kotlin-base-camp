package com.prosoft.webinar18

// Пример 11. Вариантность: инвариантность, out и in.
// Почему Container<Dog> не является Container<Animal> и как два модификатора это меняют.
//
// Инвариантный класс назван Container (а не Box), чтобы не конфликтовать
// с классом Box из примера 8 (TypedBoxDemo.kt) — оба лежат в одном пакете.

open class Animal(val name: String) { override fun toString() = name }
class Dog(name: String) : Animal(name)
class Cat(name: String) : Animal(name)

// Инвариантный — режим по умолчанию, модификатора нет
class Container<T>(private var item: T) {
    fun get(): T = item
    fun put(value: T) { item = value }   // и читаем, и пишем — послабление опасно
}

// Ковариантный: только производит значения
class Producer<out T>(private val item: T) {
    fun get(): T = item
    // fun put(value: T) {}   // не скомпилируется: T в in-позиции запрещён
}

// Контравариантный: только потребляет значения
class Consumer<in T> {
    fun consume(value: T) { println("Обработали: $value") }
    // fun get(): T          // не скомпилируется: T в out-позиции запрещён
}

// Проекции типов: вариантность в точке использования
fun copyAnimals(source: MutableList<out Animal>, destination: MutableList<in Animal>) {
    destination.addAll(source)
}

class VarianceDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // 1. ИНВАРИАНТНОСТЬ — связи нет ни в одну сторону
            val dogContainer = Container(Dog("Рекс"))
            // val animalContainer: Container<Animal> = dogContainer   // Type mismatch
            println("Container инвариантен: Container<Dog> и Container<Animal> не связаны")
            println("  проверка: ${dogContainer.get().name}")

            // 2. КОВАРИАНТНОСТЬ — отношение сохраняется
            val dogProducer: Producer<Dog> = Producer(Dog("Бобик"))
            val animalProducer: Producer<Animal> = dogProducer      // работает благодаря out
            println("Producer<Dog> подошёл как Producer<Animal>: ${animalProducer.get().name}")

            // List в Kotlin объявлен как List<out T> — тоже ковариантен
            val dogs: List<Dog> = listOf(Dog("Шарик"))
            val animals: List<Animal> = dogs                        // работает
            println("List<Dog> подошёл как List<Animal>: ${animals.size}")

            // 3. КОНТРАВАРИАНТНОСТЬ — отношение переворачивается
            val animalConsumer = Consumer<Animal>()
            val dogConsumer: Consumer<Dog> = animalConsumer         // работает благодаря in
            dogConsumer.consume(Dog("Тузик"))       // Обработали: Тузик

            // sortedWith принимает Comparator<in T> (проекция в сигнатуре),
            // поэтому компаратор для Animal годится для списка Dog
            val byName: Comparator<Animal> = Comparator { a, b -> a.name.compareTo(b.name) }
            println(listOf(Dog("Рекс"), Dog("Бобик")).sortedWith(byName).map { it.name })

            // 4. ПРОЕКЦИИ ТИПОВ — MutableList инвариантен, но проекции его ослабляют
            val allAnimals = mutableListOf<Animal>()
            copyAnimals(mutableListOf(Dog("Дружок")), allAnimals)
            copyAnimals(mutableListOf(Cat("Мурка")), allAnimals)
            println("Скопировали: ${allAnimals.map { it.name }}")
        }
    }
}
