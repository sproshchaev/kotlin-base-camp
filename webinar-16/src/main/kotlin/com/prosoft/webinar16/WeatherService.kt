package com.prosoft.webinar16

// Пример 7. Сервис с внешней зависимостью — почва для мокинга (примеры 8, 9).
data class Weather(val description: String, val temperature: Int)

interface WeatherApiClient {
    fun fetchWeather(city: String): Weather   // в реальности — сетевой вызов
}

class WeatherService(private val apiClient: WeatherApiClient) {
    // Зависимость приходит в конструкторе (DI) — в тесте можно подсунуть мок.
    fun getWeather(city: String): Weather = apiClient.fetchWeather(city)
}

// Пример 13. Реальный объект с настоящей логикой — для демонстрации spyk.
class RealWeatherService {
    fun fetchWeather(city: String): String = "Sunny in $city"
}
