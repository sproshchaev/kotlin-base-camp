package com.prosoft.webinar12

// принимает max и возвращает готовый предикат (Int) -> Boolean
fun priceUnder(max: Int): (Int) -> Boolean = { price -> price <= max }

class CurryingFactoryDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val prices = listOf(200, 600, 1000, 1500)

            val cheap = priceUnder(500)       // специализированный предикат
            val moderate = priceUnder(1200)   // ещё один, из той же фабрики

            println(prices.filter(cheap))      // [200]
            println(prices.filter(moderate))   // [200, 600, 1000]
        }
    }
}
