package com.prosoft.webinar20

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Точка входа Spring Boot приложения.
 *
 * @SpringBootApplication включает автоконфигурацию, сканирование компонентов
 * (@RestController, @Service, @Repository) и настройку веб-слоя.
 *
 * runApplication поднимает встроенный Tomcat — по умолчанию на порту 8080.
 * В отличие от консольных программ, приложение не завершается, а «слушает» сеть.
 */
@SpringBootApplication
class Webinar20Application

fun main(args: Array<String>) {
    runApplication<Webinar20Application>(*args)
}
