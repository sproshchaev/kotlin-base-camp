package com.prosoft.webinar17

// Пример 2. Делегирование класса через by — добавляем логирование поверх реализации.
interface Repository {
    fun save(item: String)
    fun getAll(): List<String>
}

class InMemoryRepository : Repository {
    private val items = mutableListOf<String>()
    override fun save(item: String) { items.add(item) }
    override fun getAll(): List<String> = items.toList()
}

class LoggingRepository(private val delegate: Repository) : Repository by delegate {
    override fun save(item: String) {
        println("  [LOG] сохраняю: $item")
        delegate.save(item)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val repo = LoggingRepository(InMemoryRepository())
            repo.save("Kotlin")
            repo.save("Delegation")
            println("Содержимое: ${repo.getAll()}")
        }
    }
}
