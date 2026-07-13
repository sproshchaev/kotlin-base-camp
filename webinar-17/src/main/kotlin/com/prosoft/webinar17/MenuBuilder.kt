package com.prosoft.webinar17

// Пример 8. @DslMarker — ограничение областей видимости во вложенных DSL-блоках.
@DslMarker
annotation class MenuDsl

@MenuDsl
class MenuBuilder {
    private val items = mutableListOf<String>()
    fun item(name: String) { items.add(name) }
    fun submenu(name: String, block: MenuBuilder.() -> Unit) {
        val sub = MenuBuilder()
        sub.block()
        items.add("$name -> [${sub.items.joinToString(", ")}]")
    }
    fun build(): List<String> = items

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = menu {
                item("Главная")
                submenu("Настройки") {
                    item("Профиль")
                    item("Безопасность")
                    // item здесь относится к submenu, а не к внешнему меню — это гарантирует @DslMarker
                }
            }
            result.forEach { println(it) }
        }
    }
}

fun menu(block: MenuBuilder.() -> Unit): List<String> {
    val builder = MenuBuilder()
    builder.block()
    return builder.build()
}
