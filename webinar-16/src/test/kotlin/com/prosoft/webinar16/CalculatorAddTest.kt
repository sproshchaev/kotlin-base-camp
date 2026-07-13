package com.prosoft.webinar16

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

// Пример 2. Первый тест: @Test и assertEquals.
class CalculatorAddTest {

    private val calculator = Calculator()

    @Test
    fun `when adding 1 and 2 expect 3`() {
        val result = calculator.add(1, 2)
        assertEquals(3, result)   // (ожидаемое, фактическое)
    }
}
