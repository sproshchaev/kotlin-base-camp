package com.prosoft.webinar16

import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

// Пример 13. spyk — частичный мок реального объекта.
class WeatherServiceSpyTest {

    @Test
    fun `spy calls real method and records the call`() {
        val spy = spyk(RealWeatherService())          // оборачиваем реальный объект

        val result = spy.fetchWeather("New York")      // выполняется НАСТОЯЩИЙ метод

        assertEquals("Sunny in New York", result)
        verify { spy.fetchWeather("New York") }        // вызов зафиксирован
    }

    @Test
    fun `spy can override a single method`() {
        val spy = spyk(RealWeatherService())
        every { spy.fetchWeather("Mars") } returns "No data"   // переопределяем только этот вызов

        assertEquals("No data", spy.fetchWeather("Mars"))           // заглушка
        assertEquals("Sunny in London", spy.fetchWeather("London")) // остальное — реальный метод
    }
}
