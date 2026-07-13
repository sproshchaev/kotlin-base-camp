package com.prosoft.webinar17

import kotlin.reflect.KProperty

// Пример 6. Собственный делегат свойства: операторы getValue / setValue.
class NonBlank(private var value: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = if (newValue.isBlank()) {
            println("  [${property.name}] пустое значение отклонено, оставляю '$value'")
            value
        } else {
            newValue
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val form = Form()
            println("Изначально: ${form.username}")
            form.username = "alice"
            println("После ввода: ${form.username}")
            form.username = "   "   // отклонено
            println("После пустого ввода: ${form.username}")
        }
    }
}

class Form {
    var username: String by NonBlank("guest")
}
