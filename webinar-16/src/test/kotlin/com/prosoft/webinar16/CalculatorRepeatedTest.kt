package com.prosoft.webinar16

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Assertions.assertEquals

// Пример 10. @RepeatedTest — повторяющийся прогон одного теста.
class CalculatorRepeatedTest {

    private val calculator = Calculator()

    @RepeatedTest(value = 5, name = "run {currentRepetition} of {totalRepetitions}")
    fun `add is stable`() {
        assertEquals(4, calculator.add(2, 2))
    }
}
