package com.prosoft.webinar16

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows

// Пример 3. Разные assertion'ы: assertTrue и assertThrows.
class CalculatorAssertionsTest {

    private val calculator = Calculator()

    @Test
    fun `when 2 is checked if even expect true`() {
        assertTrue(calculator.isEven(2))
    }

    @Test
    fun `when dividing by 0 expect IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            calculator.divide(10, 0)
        }
    }
}
