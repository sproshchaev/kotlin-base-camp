package com.prosoft.webinar15

// Пример 11. Практика: валидатор email
class EmailValidatorDemo {
    companion object {
        // ^ и $ — якоря начала и конца строки: проверяем адрес ЦЕЛИКОМ
        private val emailRegex = Regex("""^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")

        private fun isValid(email: String): Boolean = emailRegex.matches(email)

        @JvmStatic
        fun main(args: Array<String>) {
            println(isValid("ann@example.com"))      // true
            println(isValid("joe_blow@mail.co.uk"))  // true
            println(isValid("not-an-email"))         // false — нет @ и домена
            println(isValid("spam@site.com extra"))  // false — якоря отсекают "хвост"
        }
    }
}
