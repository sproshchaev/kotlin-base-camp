package com.prosoft.webinar13

// Пример 7. Ручной выброс исключения (throw) со специфичным типом
fun calculateSpentMoney(total: Int, itemPrice: Int): Int {
    if (total < 0) throw IllegalArgumentException("Total can't be negative: $total")
    if (itemPrice < 0) throw IllegalArgumentException("Item price can't be negative: $itemPrice")
    if (itemPrice == 0) return 0
    val amountToBuy = total / itemPrice
    return amountToBuy * itemPrice
}

class ThrowDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(calculateSpentMoney(100, 30))   // 90 — корректно
            calculateSpentMoney(-100, 30)           // упадёт: IllegalArgumentException
        }
    }
}
