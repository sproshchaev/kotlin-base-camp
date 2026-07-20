package com.prosoft.webinar18

// Пример 6. Композиция через делегирование.
// Альтернатива наследованию: собираем класс из готовых блоков через ключевое слово by.

interface Level { fun getLevel(): Int }
interface Enemy { fun isEnemy(): Boolean }
interface Role  { fun getRole(): String }

// Реализации создаём один раз как объекты-одиночки
object Dangerous    : Level { override fun getLevel() = 10 }
object NotDangerous : Level { override fun getLevel() = 1 }
object Foe    : Enemy { override fun isEnemy() = true }
object Friend : Enemy { override fun isEnemy() = false }
object Warrior : Role { override fun getRole() = "Воин" }
object Wizard  : Role { override fun getRole() = "Маг" }

// Наследование: всё пишем руками
class DangerousEnemyWarriorOld : Level, Enemy, Role {
    override fun getLevel() = 10
    override fun isEnemy() = true
    override fun getRole() = "Воин"
}

// Композиция: собираем из блоков, тела у класса нет вообще
class DangerousEnemyWarrior : Level by Dangerous, Enemy by Foe, Role by Warrior
class FriendlyWizard        : Level by NotDangerous, Enemy by Friend, Role by Wizard

// Принимаем сразу три интерфейса — компилятор проверит, что аргумент реализует все
fun <T> describe(character: T) where T : Level, T : Enemy, T : Role {
    val side = if (character.isEnemy()) "враг" else "союзник"
    println("${character.getRole()}, уровень ${character.getLevel()}, $side")
}

class CharacterCompositionDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            describe(DangerousEnemyWarrior())     // Воин, уровень 10, враг
            describe(FriendlyWizard())            // Маг, уровень 1, союзник
            describe(DangerousEnemyWarriorOld())  // Воин, уровень 10, враг
        }
    }
}
