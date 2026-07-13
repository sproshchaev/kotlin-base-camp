package com.prosoft.webinar16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

// Пример 6. @CsvSource — несколько параметров на каждый прогон.
class CalculatorCsvSourceTest {

    private val calculator = Calculator()

    @ParameterizedTest(name = "maxOf({0}, {1}) == {2}")
    @CsvSource(
        "2, 1, 2",
        "1, 2, 2",
        "5, 5, 5"
    )
    fun `maxOf returns the larger value`(first: Int, second: Int, expected: Int) {
        assertEquals(expected, calculator.maxOf(first, second))
    }
}
