package com.prosoft.webinar17

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// Пример 10. Контракт returns(true) implies — включает smartcast для receiver'а.
@OptIn(ExperimentalContracts::class)
fun String?.isNotNullOrBlank(): Boolean {
    contract {
        returns(true) implies (this@isNotNullOrBlank != null)
    }
    return !this.isNullOrBlank()
}

class SmartcastContractDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val name: String? = "Kotlin"
            if (name.isNotNullOrBlank()) {
                // компилятор сделал smartcast String? -> String, .length доступен без ?.
                println("Длина имени: ${name.length}")
            }

            val empty: String? = null
            println("empty валиден? ${empty.isNotNullOrBlank()}")
        }
    }
}
