
| №   | Файл                      | Что демонстрирует                                                           |
| --- | ------------------------- | --------------------------------------------------------------------------- |
| 1   | `NullableBasicsDemo.kt`   | Деление типов на nullable/non-nullable; знак `?` делает тип nullable        |
| 2   | `DirectAccessDemo.kt`     | Прямое обращение к nullable не компилируется; спасает проверка `if != null` |
| 3   | `SafeCallDemo.kt`         | Безопасный вызов `?.` — доступ к свойствам без NPE                          |
| 4   | `SafeCallChainDemo.kt`    | Цепочка `?.` прерывается на первом `null`                                   |
| 5   | `ElvisDemo.kt`            | Оператор Элвиса `?:` — значение по умолчанию вместо `null`                  |
| 6   | `ElvisThrowDemo.kt`       | Элвис с `throw` — ранняя проверка и выход                                   |
| 7   | `NotNullAssertionDemo.kt` | Оператор `!!` — аварийный инструмент, возвращает NPE                        |
| 8   | `TypeCheckDemo.kt`        | Проверка типа `is` в связке с `when`                                        |
| 9   | `SmartCastDemo.kt`        | Smart cast после `is` — объект сам приводится к типу                        |
| 10  | `SmartCastReturnDemo.kt`  | Smart cast после раннего `return` при `null`                                |
| 11  | `CastDemo.kt`             | Приведение `as` (падает) против `as?` (возвращает `null`)                   |
| 12  | `CollectionsNullDemo.kt`  | Коллекции и null: `?:`, `listOfNotNull`, `getOrNull`                        |
