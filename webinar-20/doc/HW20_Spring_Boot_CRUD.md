# ДЗ #20 — Spring Boot + Kotlin: REST API для библиотеки

Домашнее задание к вебинару 20 курса **Kotlin Base Camp**. Финал: всё, что строили в течение курса, превращается в полноценный REST-сервис — REST-контроллер с CRUD, база данных через JPA, тесты endpoints, упаковка в jar.

## Задание

### Задача 1. Подготовка зависимостей

Обновите `build.gradle.kts`:

```kotlin
plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    kotlin("plugin.jpa") version "1.9.23"
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.library"
version = "1.0.0"

repositories { mavenCentral() }

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")              // встроенная БД для разработки

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.test { useJUnitPlatform() }
```

Зачем плагины:
- `kotlin("plugin.spring")` — делает классы Spring (`@Component`, `@Service`, etc.) автоматически `open` (Spring требует не‑final).
- `kotlin("plugin.jpa")` — добавляет no‑arg constructor для `@Entity` (JPA требует).

### Задача 2. Application class

Создайте `src/main/kotlin/com/library/LibraryApplication.kt`:

```kotlin
package com.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {
    runApplication<LibraryApplication>(*args)
}
```

Это всё. После запуска (`./gradlew bootRun`) — embedded Tomcat поднимется на порту 8080.

### Задача 3. JPA Entity

Создайте `src/main/kotlin/com/library/api/BookEntity.kt`:

```kotlin
package com.library.api

import jakarta.persistence.*

@Entity
@Table(name = "books")
class BookEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var author: String = "",

    @Column(nullable = false)
    var year: Int = 0,

    @Column(nullable = false)
    var price: Double = 0.0,

    @Column(nullable = false)
    var copies: Int = 0,

    @Column(unique = true)
    var isbn: String? = null,
)
```

Заметки:
- Класс не `data class` (для JPA Entity это спорно — `equals/hashCode` от data class могут сломать ленивую загрузку). Используем обычный `class` с `var` полями.
- Все параметры с дефолтами — для no‑arg constructor (jpa плагин это решает, но дефолты тоже не помешают).
- `@Column(unique = true)` для ISBN — на уровне БД.

### Задача 4. Repository

```kotlin
package com.library.api

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookEntity, Long> {
    fun findByIsbn(isbn: String): BookEntity?
    fun findByAuthorContainingIgnoreCase(author: String): List<BookEntity>
}
```

Spring Data **сам** реализует методы по имени:
- `findByIsbn` → `WHERE isbn = ?`.
- `findByAuthorContainingIgnoreCase` → `WHERE LOWER(author) LIKE LOWER('%?%')`.

### Задача 5. DTOs

Создайте `src/main/kotlin/com/library/api/BookDto.kt`:

```kotlin
package com.library.api

data class BookCreateDto(
    val title: String,
    val author: String,
    val year: Int,
    val price: Double,
    val copies: Int,
    val isbn: String? = null,
)

data class BookResponseDto(
    val id: Long,
    val title: String,
    val author: String,
    val year: Int,
    val price: Double,
    val copies: Int,
    val isbn: String?,
)

fun BookEntity.toDto(): BookResponseDto = BookResponseDto(
    id = id ?: error("Entity not persisted"),
    title = title, author = author, year = year,
    price = price, copies = copies, isbn = isbn,
)

fun BookCreateDto.toEntity(): BookEntity = BookEntity(
    title = title, author = author, year = year,
    price = price, copies = copies, isbn = isbn,
)
```

Extension‑функции `toDto`/`toEntity` (вспомнили ДЗ #18!) — для маппинга.

### Задача 6. Service

```kotlin
package com.library.api

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BookService(private val repo: BookRepository) {

    fun all(): List<BookResponseDto> = repo.findAll().map { it.toDto() }

    fun byId(id: Long): BookResponseDto? = repo.findByIdOrNull(id)?.toDto()

    fun byIsbn(isbn: String): BookResponseDto? = repo.findByIsbn(isbn)?.toDto()

    fun searchByAuthor(author: String): List<BookResponseDto> =
        repo.findByAuthorContainingIgnoreCase(author).map { it.toDto() }

    fun create(dto: BookCreateDto): BookResponseDto {
        require(dto.title.isNotBlank()) { "Title required" }
        require(dto.year in 1450..2100) { "Year out of range" }
        require(dto.price >= 0) { "Price must be non-negative" }
        require(dto.copies >= 0) { "Copies must be non-negative" }
        return repo.save(dto.toEntity()).toDto()
    }

    fun update(id: Long, dto: BookCreateDto): BookResponseDto? {
        val existing = repo.findByIdOrNull(id) ?: return null
        existing.title = dto.title
        existing.author = dto.author
        existing.year = dto.year
        existing.price = dto.price
        existing.copies = dto.copies
        existing.isbn = dto.isbn
        return repo.save(existing).toDto()
    }

    fun delete(id: Long): Boolean {
        if (!repo.existsById(id)) return false
        repo.deleteById(id)
        return true
    }
}
```

### Задача 7. Controller

```kotlin
package com.library.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(private val service: BookService) {

    @GetMapping
    fun list(@RequestParam(required = false) author: String?): List<BookResponseDto> =
        if (author != null) service.searchByAuthor(author) else service.all()

    @GetMapping("/{id}")
    fun byId(@PathVariable id: Long): ResponseEntity<BookResponseDto> =
        service.byId(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @GetMapping("/isbn/{isbn}")
    fun byIsbn(@PathVariable isbn: String): ResponseEntity<BookResponseDto> =
        service.byIsbn(isbn)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: BookCreateDto): BookResponseDto = service.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: BookCreateDto): ResponseEntity<BookResponseDto> =
        service.update(id, dto)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> =
        if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
}
```

### Задача 8. Глобальная обработка ошибок

```kotlin
package com.library.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

data class ErrorResponse(val error: String, val message: String?)

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse("Bad Request", e.message))

    @ExceptionHandler(Exception::class)
    fun handleGeneric(e: Exception): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse("Internal Server Error", e.message))
}
```

Теперь `require(dto.title.isNotBlank())` в сервисе → 400 Bad Request с понятным телом.

### Задача 9. Конфигурация H2

`src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:librarydb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
```

После запуска можно зайти на http://localhost:8080/h2-console и посмотреть БД глазами (URL: `jdbc:h2:mem:librarydb`, user `sa`, без пароля).

### Задача 10. Запуск и ручное тестирование

```
./gradlew bootRun
```

Сервис стартует на http://localhost:8080. Проверьте:

```bash
# Создать книгу
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title": "Чистый код", "author": "Р. Мартин", "year": 2008, "price": 1290.0, "copies": 3, "isbn": "9785916719892"}'

# Список
curl http://localhost:8080/api/books

# По ID (подставьте реальный)
curl http://localhost:8080/api/books/1

# По ISBN
curl http://localhost:8080/api/books/isbn/9785916719892

# Поиск по автору
curl "http://localhost:8080/api/books?author=Мартин"

# Обновить
curl -X PUT http://localhost:8080/api/books/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Чистый код (2-е изд.)", "author": "Р. Мартин", "year": 2008, "price": 1490.0, "copies": 5, "isbn": "9785916719892"}'

# Удалить
curl -X DELETE http://localhost:8080/api/books/1
```

### Задача 11. Тест controller'а через `MockMvc`

```kotlin
package com.library.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
) {

    @Test
    fun `POST then GET returns the book`() {
        val dto = BookCreateDto("Test Book", "Test Author", 2020, 999.0, 1)
        val json = objectMapper.writeValueAsString(dto)

        val response = mockMvc.perform(
            post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.title").value("Test Book"))
            .andReturn()

        val created = objectMapper.readValue(response.response.contentAsString, BookResponseDto::class.java)

        mockMvc.perform(get("/api/books/${created.id}"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.title").value("Test Book"))
    }

    @Test
    fun `GET non-existing returns 404`() {
        mockMvc.perform(get("/api/books/99999"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `POST with invalid year returns 400`() {
        val invalid = BookCreateDto("X", "Y", 3000, 100.0, 1)
        mockMvc.perform(
            post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalid))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.error").value("Bad Request"))
    }
}
```

### Задача 12. Упаковка

```
./gradlew build
```

Появится `build/libs/library-1.0.0.jar`. Запустите:

```
java -jar build/libs/library-1.0.0.jar
```

Это **исполняемый jar** с встроенным Tomcat. Можно деплоить как есть — никаких внешних серверов.

## Критерии готовности

- [ ] Spring Boot стартует на 8080, отвечает по `/api/books`
- [ ] Все 5 CRUD‑операций (`GET list`, `GET by id`, `POST`, `PUT`, `DELETE`) работают через curl/Postman
- [ ] `findByIsbn` и `findByAuthorContaining...` работают через query‑методы Spring Data
- [ ] Entity и DTO **разделены**, маппинг через extension‑функции
- [ ] Глобальная обработка `IllegalArgumentException` → 400 Bad Request с понятным телом
- [ ] H2 console доступна на `/h2-console`, показывает таблицу `BOOKS`
- [ ] Минимум 3 теста через `MockMvc`: успешный CRUD, 404, 400 на невалидные данные
- [ ] `./gradlew build` собирает работающий jar

## Типичные грабли

- **Возврат Entity напрямую.** Изменение модели БД ломает API. Всегда DTO.
- **`final class` для Entity.** JPA не умеет создавать прокси для final — используйте `kotlin-spring`/`kotlin-jpa` плагины.
- **Lazy loading без `@Transactional`.** Контроллер читает поле lazy‑коллекции — `LazyInitializationException`. `@Transactional` на сервисе спасает.
- **`open class` руками вместо плагина.** Работает, но многословно. Плагины Spring/JPA автоматически делают всё, что нужно.
- **`@Autowired` на field injection.** Не работает с `val`, нет проверки в тестах. Constructor injection — стандарт.
- **Спутанные HTTP‑методы.** POST для создания, PUT для полной замены, PATCH для частичного, DELETE для удаления. GET — **не** для action'ов вроде `?action=delete`.
- **Возврат `null` из контроллера.** Может стать `200 OK` с пустым телом — клиент не поймёт. Используйте `ResponseEntity.notFound().build()`.
- **Внутренний путь H2 console.** На production выключайте. Это **открытый** доступ к БД.

## Вопросы для самопроверки

1. Зачем нужны `kotlin-spring` и `kotlin-jpa` плагины?
2. В чём разница между `@RestController` и `@Controller`?
3. Что такое DI и какой способ injection предпочтителен в Kotlin?
4. Зачем DTO, если можно вернуть Entity?
5. Как Spring Data находит реализацию `findByAuthorContainingIgnoreCase`?
6. Что такое `@Transactional`? Когда транзакция начинается и заканчивается?
7. Почему `MockMvc` лучше, чем поднимать реальный сервер для тестов?

## Что сдать — через Pull Request

1. Из свежего `main` создаём ветку `homework/w20`:
   ```bash
   git checkout main
   git pull upstream main
   git checkout -b homework/w20
   ```

2. После реализации — коммит и push:
   ```bash
   git add .
   git commit -m "feat: Spring Boot REST API with full CRUD, H2 storage, integration tests"
   git push origin homework/w20
   ```

3. На GitHub открыть **Pull Request**: base = `main`, compare = `homework/w20`.
   ⚠ **`base repository` — ваш fork, не `sproshchaev/kotlin-base-camp`!**

4. URL созданного PR отправить в **[Google Classroom](https://classroom.google.com/w/ODYzMjQ0NzM0OTQz/t/all)**.
