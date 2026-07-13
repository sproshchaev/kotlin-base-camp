package com.prosoft.webinar17

// Пример 11. Проверки require / check / assert и их разное назначение.
class BankAccount(initial: Int) {
    var balance: Int = initial
        private set

    fun withdraw(amount: Int) {
        require(amount > 0) { "Сумма должна быть положительной, а не $amount" }
        check(balance >= amount) { "Недостаточно средств: баланс $balance, запрошено $amount" }

        balance -= amount

        assert(balance >= 0) { "Баланс не может стать отрицательным" }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val account = BankAccount(100)
            account.withdraw(30)
            println("Баланс после снятия 30: ${account.balance}")

            try {
                account.withdraw(-5)   // сработает require
            } catch (e: IllegalArgumentException) {
                println("require поймал: ${e.message}")
            }

            try {
                account.withdraw(1000) // сработает check
            } catch (e: IllegalStateException) {
                println("check поймал: ${e.message}")
            }
        }
    }
}
