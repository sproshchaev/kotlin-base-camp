package com.prosoft.webinar20.service

import com.prosoft.webinar20.dto.NoteCreateDto
import com.prosoft.webinar20.dto.NoteResponseDto
import com.prosoft.webinar20.dto.toResponse
import com.prosoft.webinar20.repository.NoteRepository
import org.springframework.stereotype.Service

/**
 * Слой бизнес-логики. Здесь — валидация и маппинг доменной модели в DTO.
 *
 * @Service помечает класс как бин-сервис. Зависимость (NoteRepository)
 * приходит через КОНСТРУКТОР — Spring сам находит нужный бин и подставляет.
 * Раньше мы писали это руками: val service = NoteService(repository).
 */
@Service
class NoteService(private val repository: NoteRepository) {

    fun all(): List<NoteResponseDto> =
        repository.findAll().map { it.toResponse() }

    fun byId(id: Long): NoteResponseDto? =
        repository.findById(id)?.toResponse()

    fun create(dto: NoteCreateDto): NoteResponseDto {
        validate(dto)
        return repository.save(dto.title, dto.text).toResponse()
    }

    fun update(id: Long, dto: NoteCreateDto): NoteResponseDto? {
        validate(dto)
        return repository.update(id, dto.title, dto.text)?.toResponse()
    }

    fun delete(id: Long): Boolean =
        repository.deleteById(id)

    /**
     * Валидация через require (мост: вебинар 13). При нарушении бросается
     * IllegalArgumentException, который GlobalExceptionHandler превращает
     * в ответ 400 Bad Request с понятным телом.
     */
    private fun validate(dto: NoteCreateDto) {
        require(dto.title.isNotBlank()) { "Заголовок не может быть пустым" }
        require(dto.title.length <= 100) { "Заголовок не длиннее 100 символов" }
    }
}
