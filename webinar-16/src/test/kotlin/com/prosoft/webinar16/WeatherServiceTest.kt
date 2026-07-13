package com.prosoft.webinar16

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

// Пример 8. MockK: mockk, every/returns, verify.
class WeatherServiceTest {

    private val mockApiClient = mockk<WeatherApiClient>()
    private val weatherService = WeatherService(mockApiClient)

    @Test
    fun `getWeather returns data from api client`() {
        val expected = Weather("Sunny", 25)
        every { mockApiClient.fetchWeather("New York") } returns expected  // задаём поведение

        val actual = weatherService.getWeather("New York")

        assertEquals(expected, actual)                          // проверяем результат
        verify { mockApiClient.fetchWeather("New York") }       // проверяем, что вызов был
    }
}
