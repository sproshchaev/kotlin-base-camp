package com.prosoft.webinar20.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/** Тело ответа об ошибке. */
data class ErrorResponse(val error: String, val message: String?)

/**
 * Глобальная обработка ошибок для всех контроллеров.
 *
 * require(...) в сервисе бросает IllegalArgumentException — здесь мы
 * перехватываем его и превращаем в аккуратный ответ 400 Bad Request
 * с понятным телом, вместо стандартной ошибки 500.
 */
@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<ErrorResponse> =
        ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse("Bad Request", e.message))
}
