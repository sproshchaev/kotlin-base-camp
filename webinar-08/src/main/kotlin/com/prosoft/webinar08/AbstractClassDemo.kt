package com.prosoft.webinar08

abstract class Payment(val amount: Int) {
    abstract val method: String           // обязан задать подкласс
    abstract fun pay(): String            // обязан реализовать подкласс

    fun receipt(): String = "Оплата $amount через $method"  // готовый метод
}

class CardPayment(amount: Int) : Payment(amount) {
    override val method: String = "карту"
    override fun pay(): String = "Списано $amount с карты"
}

fun main() {
    // val p = Payment(100)            // ошибка: нельзя создать абстрактный класс
    val payment: Payment = CardPayment(500)
    println(payment.pay())
    println(payment.receipt())          // унаследованный готовый метод
}
// Списано 500 с карты
// Оплата 500 через карту