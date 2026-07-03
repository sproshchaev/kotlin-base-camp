package com.prosoft.webinar13

// Пример 2. Предотвращение исключения проверкой условия (if)
fun itemPrice(total: Int, amount: Int): Int {
    if (amount == 0) {              // проверка граничного случая
        println("Division by zero")
        return 0
    }
    return total / amount
}

class InputValidationDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(itemPrice(100, 4))   // 25 — обычный случай
            println(itemPrice(100, 0))   // 0 — без падения
        }
    }
}
