package com.prosoft.webinar08

open class Notification(val text: String) {
    open fun render(): String = "Сообщение: $text"
}

class EmailNotification(text: String, val email: String) : Notification(text) {
    override fun render(): String = super.render() + " (отправлено на $email)"
}

fun main() {
    val base = Notification("Привет")
    val mail = EmailNotification("Привет", "user@mail.ru")
    println(base.render())
    println(mail.render())
}
// Сообщение: Привет
// Сообщение: Привет (отправлено на user@mail.ru)