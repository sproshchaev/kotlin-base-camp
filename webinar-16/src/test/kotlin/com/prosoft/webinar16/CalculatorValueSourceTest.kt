package com.prosoft.webinar16

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

// Пример 5. @ParameterizedTest + @ValueSource — один тест на множестве значений.
class CalculatorValueSourceTest {

    private val calculator = Calculator()

    @ParameterizedTest(name = "{0} is even")
    @ValueSource(ints = [0, 2, 4, 100, 1000])
    fun `even numbers are detected`(number: Int) {
        assertTrue(calculator.isEven(number))
    }
}
