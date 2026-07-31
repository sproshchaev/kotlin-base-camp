
Демо к вебинару **«20. Spring Boot: CRUD-приложение на Kotlin»**.

Простейший REST-сервис управления заметками (`Note`). Хранение — в памяти, без базы
данных: цель демо — показать веб-слой, слои приложения и внедрение зависимостей.
Работа с БД (Spring Data JPA + H2) выносится в домашнее задание.

## Запуск

```bash
./gradlew :webinar-20:bootRun
```

Приложение поднимется на `http://localhost:8080`. Проверка через `curl` или Postman.

## Эндпоинты

| Метод  | URL               | Действие              | Ответ                    |
|--------|-------------------|-----------------------|--------------------------|
| GET    | `/api/notes`      | список всех заметок   | 200 OK                   |
| GET    | `/api/notes/{id}` | одна заметка по id    | 200 OK / 404 Not Found   |
| POST   | `/api/notes`      | создать заметку       | 201 Created / 400        |
| PUT    | `/api/notes/{id}` | заменить заметку      | 200 OK / 404 Not Found   |
| DELETE | `/api/notes/{id}` | удалить заметку       | 204 No Content / 404     |

Пример:

```bash
# создать
curl -X POST http://localhost:8080/api/notes \
  -H "Content-Type: application/json" \
  -d '{"title": "Купить хлеб", "text": "молоко, яйца"}'

# список
curl http://localhost:8080/api/notes

# по id
curl http://localhost:8080/api/notes/1

# заменить
curl -X PUT http://localhost:8080/api/notes/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Купить продукты", "text": "молоко, яйца, хлеб"}'

# удалить
curl -X DELETE http://localhost:8080/api/notes/1

# валидация: пустой заголовок -> 400 Bad Request
curl -X POST http://localhost:8080/api/notes \
  -H "Content-Type: application/json" \
  -d '{"title": "", "text": "..."}'
```

## Файлы

| №  | Файл                        | Роль                | Ключевые конструкции                                  |
|----|-----------------------------|---------------------|-------------------------------------------------------|
| 1  | `Webinar20Application.kt`   | точка входа         | `@SpringBootApplication`, `runApplication`            |
| 2  | `Note.kt`                   | доменная модель     | `data class` (отделён от DTO)                          |
| 3  | `NoteDto.kt`                | DTO + маппинг       | `data class`, extension-функция `toResponse`          |
| 4  | `NoteRepository.kt`         | хранилище в памяти  | `@Repository`, `ConcurrentHashMap`, `AtomicLong`      |
| 5  | `NoteService.kt`            | бизнес-логика       | `@Service`, DI через конструктор, `require`           |
| 6  | `NoteController.kt`         | веб-слой (REST)     | `@RestController`, `@GetMapping`/`@PostMapping`/…, `ResponseEntity` |
| 7  | `GlobalExceptionHandler.kt` | обработка ошибок    | `@ControllerAdvice`, `@ExceptionHandler` → 400        |

## Структура

```
webinar-20/
├── build.gradle.kts
├── README.md
└── src/main/kotlin/com/prosoft/webinar20/
    ├── Webinar20Application.kt
    ├── Note.kt
    ├── NoteDto.kt
    ├── NoteRepository.kt
    ├── NoteService.kt
    ├── NoteController.kt
    └── GlobalExceptionHandler.kt
```

## Замечания

- Хранилище потокобезопасно (`ConcurrentHashMap` + `AtomicLong`): веб-сервер
  обрабатывает запросы в нескольких потоках одновременно (мост: вебинар 19).
- `Note` (доменная модель) отделён от `NoteResponseDto`/`NoteCreateDto`: внутреннюю
  модель можно менять, не ломая контракт API. Это готовит почву к разделению
  Entity ↔ DTO в домашнем задании.
- Валидация в `NoteService` через `require` бросает `IllegalArgumentException`,
  который `GlobalExceptionHandler` превращает в ответ 400 (мост: вебинар 13).
- Это первый модуль курса со Spring Boot, поэтому его `build.gradle.kts` добавляет
  плагины и стартеры Spring с явными версиями (version catalog в проекте не используется).
