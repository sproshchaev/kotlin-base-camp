
Демо к вебинару **«16. Сборка проектов. Модульное тестирование»**.

Проект собирается Gradle. Запуск тестов: `./gradlew :webinar-16:test` или зелёная иконка в IDE рядом с методом/классом.

Домены примеров:
- `Calculator` — сквозной «подопытный» класс для примеров по JUnit (базовые тесты, assertions, lifecycle, параметризация).
- `WeatherService` — сервис с внешней зависимостью для примеров по MockK.

| №  | Класс / файл                  | Тема вебинара                    | Что демонстрирует                                    |
|----|-------------------------------|----------------------------------|------------------------------------------------------|
| 0  | `build.gradle.kts`            | Настройка Gradle под тесты       | Подключение JUnit 5, MockK, `useJUnitPlatform()`     |
| 1  | `Calculator`                  | Класс под тест                   | Обычный класс-«подопытный» для тестов                |
| 2  | `CalculatorAddTest`           | Базовый тест                     | `@Test` + `assertEquals`                             |
| 3  | `CalculatorAssertionsTest`    | Виды проверок                    | `assertTrue`, `assertThrows`                         |
| 4  | `CalculatorLifecycleTest`     | Lifecycle (each)                 | `@BeforeEach` / `@AfterEach`, изоляция тестов        |
| 5  | `CalculatorValueSourceTest`   | Параметризация (1 параметр)      | `@ParameterizedTest` + `@ValueSource`                |
| 6  | `CalculatorCsvSourceTest`     | Параметризация (N параметров)    | `@ParameterizedTest` + `@CsvSource`                  |
| 7  | `WeatherService`              | Сервис с зависимостью            | DI и интерфейс — почва для мокинга                   |
| 8  | `WeatherServiceTest`          | Мокинг                           | `mockk`, `every`/`returns`, `verify`                 |
| 9  | `WeatherServiceMatchersTest`  | Argument matchers                | `any()`, `throws`                                    |
| 10 | `CalculatorRepeatedTest`      | Повторяющийся тест               | `@RepeatedTest`                                      |
| 11 | `CalculatorMethodSourceTest`  | Параметризация (метод)           | `@MethodSource` + `@JvmStatic`                       |
| 12 | `CalculatorPerClassTest`      | Lifecycle (class)                | `@TestInstance(PER_CLASS)`, `@BeforeAll`/`@AfterAll` |
| 13 | `WeatherServiceSpyTest`       | Spy                              | `spyk`, частичный мок реального объекта              |
