package com.prosoft.webinar16

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

// Пример 9. Argument matchers: any() и мок, бросающий исключение.
class WeatherServiceMatchersTest {

    private val mockApiClient = mockk<WeatherApiClient>()
    private val weatherService = WeatherService(mockApiClient)

    @Test
    fun `returns stub for any city`() {
        every { mockApiClient.fetchWeather(any()) } returns Weather("Cloudy", 15)

        assertEquals(15, weatherService.getWeather("Berlin").temperature)
        assertEquals(15, weatherService.getWeather("Tokyo").temperature)
    }

    @Test
    fun `propagates exception from api client`() {
        every { mockApiClient.fetchWeather(any()) } throws RuntimeException("Network error")

        assertThrows<RuntimeException> {
            weatherService.getWeather("Paris")
        }
    }
}
