package com.prosoft.webinar20.controller

import com.prosoft.webinar20.dto.NoteCreateDto
import com.prosoft.webinar20.dto.NoteResponseDto
import com.prosoft.webinar20.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Веб-слой (тонкий). Отвечает только за HTTP: разбор запроса, коды ответа.
 * Вся логика — в NoteService, который приходит через конструктор.
 *
 * @RestController — методы возвращают тело ответа (JSON), не имя представления.
 * @RequestMapping задаёт общий префикс пути для всех эндпоинтов.
 */
@RestController
@RequestMapping("/api/notes")
class NoteController(private val service: NoteService) {

    // GET /api/notes — список всех заметок
    @GetMapping
    fun list(): List<NoteResponseDto> = service.all()

    // GET /api/notes/{id} — одна заметка: 200 OK либо 404 Not Found
    @GetMapping("/{id}")
    fun byId(@PathVariable id: Long): ResponseEntity<NoteResponseDto> =
        service.byId(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    // POST /api/notes — создать: 201 Created
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: NoteCreateDto): NoteResponseDto =
        service.create(dto)

    // PUT /api/notes/{id} — заменить целиком: 200 OK либо 404 Not Found
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody dto: NoteCreateDto,
    ): ResponseEntity<NoteResponseDto> =
        service.update(id, dto)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    // DELETE /api/notes/{id} — удалить: 204 No Content либо 404 Not Found
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> =
        if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
}
