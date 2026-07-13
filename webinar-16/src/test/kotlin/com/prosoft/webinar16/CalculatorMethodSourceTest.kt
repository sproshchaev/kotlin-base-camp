package com.prosoft.webinar16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

// Пример 11. @MethodSource — аргументы поставляет статический метод.
class CalculatorMethodSourceTest {

    private val calculator = Calculator()

    @ParameterizedTest(name = "maxOf({0}, {1}) == {2}")
    @MethodSource("maxCases")
    fun `maxOf returns the larger value`(first: Int, second: Int, expected: Int) {
        assertEquals(expected, calculator.maxOf(first, second))
    }

    companion object {
        @JvmStatic
        fun maxCases(): List<Arguments> = listOf(
            arguments(2, 1, 2),
            arguments(1, 2, 2),
            arguments(5, 5, 5)
        )
    }
}
