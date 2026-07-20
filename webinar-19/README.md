
Демо к вебинару **«19. Многопоточность в Kotlin»**.

Каждый пример — самодостаточный класс со своим `main()`. Запуск: зелёная иконка в IDE рядом с `main`. Файлы разложены по тематическим подпакетам внутри `com.prosoft.webinar19`.

| №  | Класс (полное имя)                            | Пакет             | Тема вебинара                     | Ключевые конструкции                                                    |
|----|-----------------------------------------------|-------------------|-----------------------------------|-------------------------------------------------------------------------|
| 1  | `basics.MainThreadInfo`                       | `basics`          | Поток как объект                  | `Thread.currentThread()`, `name`, `id`, `isAlive`, `priority`, `isDaemon` |
| 2  | `basics.ThreadCreationBasics`                 | `basics`          | Создание потоков                  | `: Thread()`, `: Runnable`, `override fun run()`, лямбда                 |
| 3  | `basics.ThreadFunctionDemo`                   | `basics`          | Функция `thread()`                | `kotlin.concurrent.thread`, `start`, `name`, `block`                     |
| 4  | `basics.StartVsRunDemo`                       | `basics`          | Правила работы с потоками         | `start()` vs `run()`, `IllegalThreadStateException`                      |
| 5  | `lifecycle.SleepAndJoinDemo`                  | `lifecycle`       | Управление потоками               | `Thread.sleep()`, `TimeUnit`, `join()`, `join(millis)`                   |
| 6  | `lifecycle.ThreadExceptionsDemo`             | `lifecycle`       | Исключения в потоках              | Необработанные исключения, exit code 0 / 1                              |
| 7  | `shareddata.SharedCounterDemo`               | `shareddata`      | Разделение данных                 | Общая ссылка, heap, `join` для разведения                               |
| 8  | `shareddata.RaceConditionDemo`               | `shareddata`      | Интерференция потоков             | `count++`, потеря инкрементов, критическая секция                       |
| 9  | `synchronization.SynchronizedCounterDemo`    | `synchronization` | Синхронизация                     | `@Synchronized`, `synchronized(lock) { }`, объект-замок                  |
| 10 | `shareddata.VolatileVisibilityDemo`          | `shareddata`      | Видимость изменений               | `@Volatile`, кэширование в регистре, happens-before                     |
| 11 | `safecollections.CollectionsThreadSafetyDemo`| `safecollections` | Коллекции и потокобезопасность    | `MutableList`, `CopyOnWriteArrayList`, `ConcurrentModificationException` |
| 12 | `safecollections.StringBufferBenchmark`      | `safecollections` | StringBuffer                      | `StringBuilder` vs `StringBuffer`, цена синхронизации                    |
| 13 | `synchronization.AtomicCounterDemo`          | `synchronization` | Мостик к ДЗ                       | `AtomicInteger`, `incrementAndGet()`, CAS, lock-free                     |

## Структура

```
src/main/kotlin/com/prosoft/webinar19/
├── basics/
│   ├── MainThreadInfo.kt
│   ├── ThreadCreationBasics.kt
│   ├── ThreadFunctionDemo.kt
│   └── StartVsRunDemo.kt
├── lifecycle/
│   ├── SleepAndJoinDemo.kt
│   └── ThreadExceptionsDemo.kt
├── shareddata/
│   ├── SharedCounterDemo.kt
│   ├── RaceConditionDemo.kt
│   └── VolatileVisibilityDemo.kt
├── synchronization/
│   ├── SynchronizedCounterDemo.kt
│   └── AtomicCounterDemo.kt
└── safecollections/
    ├── CollectionsThreadSafetyDemo.kt
    └── StringBufferBenchmark.kt
```

## Замечания

- Примеры 7 → 8 → 9 → 10 образуют единую линию: общие данные → поломка → решение →
  вторая проблема. Разрывать её не стоит.
- Пример 13 не входит в счёт двенадцати — он опционален и показывается, если остаётся время.
  Класс `SafeCounterByMethod` он переиспользует из примера 9 (`SynchronizedCounterDemo.kt`);
  оба лежат в пакете `synchronization`, поэтому импорт не нужен.
- Примеры 8, 10, 11, 12 недетерминированы — запускайте их несколько раз, чтобы увидеть
  разброс результатов.
- `VolatileVisibilityDemo` без `@Volatile` не завершается: поток `spinner` не видит
  `stop = true` и крутится бесконечно, удерживая JVM. Это и есть демонстрация проблемы
  видимости — остановите запуск вручную.
