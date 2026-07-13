package com.prosoft.webinar16

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

// Пример 4. @BeforeEach / @AfterEach — подготовка и очистка на каждый тест.
class CalculatorLifecycleTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()       // свежий объект перед каждым тестом
        println("Before each test")
    }

    @AfterEach
    fun tearDown() {
        println("After each test")
    }

    @Test
    fun `add works`() {
        assertEquals(5, calculator.add(2, 3))
    }

    @Test
    fun `multiply works`() {
        assertEquals(6, calculator.multiply(2, 3))
    }
}
