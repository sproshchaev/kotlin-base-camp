package com.prosoft.webinar20.dto

import com.prosoft.webinar20.model.Note

/**
 * DTO (Data Transfer Object) — данные, которыми обмениваемся с клиентом.
 * data class идеально подходит для этого (мост: вебинар 9).
 */

// Приходит от клиента при создании/замене. Без id — его назначает сервер.
data class NoteCreateDto(
    val title: String,
    val text: String,
)

// Уходит клиенту в ответе. Содержит id.
data class NoteResponseDto(
    val id: Long,
    val title: String,
    val text: String,
)

// Маппинг доменной модели в DTO — extension-функция (мост: вебинар 18).
fun Note.toResponse(): NoteResponseDto =
    NoteResponseDto(id = id, title = title, text = text)
