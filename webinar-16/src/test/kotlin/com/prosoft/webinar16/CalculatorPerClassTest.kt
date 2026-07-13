package com.prosoft.webinar16

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

// Пример 12. @TestInstance(PER_CLASS) — один экземпляр на весь класс.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorPerClassTest {

    private val calculator = Calculator()

    @BeforeAll
    fun beforeAll() {                       // без static — благодаря PER_CLASS
        println("Once before all tests")
    }

    @AfterAll
    fun afterAll() {
        println("Once after all tests")
    }

    @Test
    fun `add works`() {
        assertEquals(4, calculator.add(2, 2))
    }

    @Test
    fun `subtract works`() {
        assertEquals(1, calculator.subtract(3, 2))
    }
}
