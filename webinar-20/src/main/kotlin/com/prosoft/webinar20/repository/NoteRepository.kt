package com.prosoft.webinar20.repository

import com.prosoft.webinar20.model.Note
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

/**
 * Хранилище заметок В ПАМЯТИ — без базы данных.
 *
 * Веб-сервер обрабатывает запросы в НЕСКОЛЬКИХ потоках одновременно, поэтому
 * хранилище потокобезопасно: ConcurrentHashMap + AtomicLong (мост: вебинар 19).
 *
 * @Repository помечает класс как бин-хранилище — Spring создаст его сам
 * и внедрит в NoteService.
 *
 * В домашнем задании этот слой заменяется на Spring Data JPA + база H2.
 */
@Repository
class NoteRepository {

    private val storage = ConcurrentHashMap<Long, Note>()
    private val idGenerator = AtomicLong(0)

    fun findAll(): List<Note> = storage.values.sortedBy { it.id }

    fun findById(id: Long): Note? = storage[id]

    fun save(title: String, text: String): Note {
        val id = idGenerator.incrementAndGet()
        val note = Note(id, title, text)
        storage[id] = note
        return note
    }

    fun update(id: Long, title: String, text: String): Note? {
        if (!storage.containsKey(id)) return null
        val updated = Note(id, title, text)
        storage[id] = updated
        return updated
    }

    fun deleteById(id: Long): Boolean = storage.remove(id) != null
}
