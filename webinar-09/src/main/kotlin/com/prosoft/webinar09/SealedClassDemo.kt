package com.prosoft.webinar09

sealed class Staff {
    class Teacher(val lessons: Int) : Staff()
    class Manager(val area: String) : Staff()
    object Worker : Staff()
}

fun describe(staff: Staff) = when (staff) {
    is Staff.Teacher -> "Учитель, уроков: ${staff.lessons}"
    is Staff.Manager -> "Менеджер: ${staff.area}"
    Staff.Worker     -> "Рабочий"
}

fun main() {
    println(describe(Staff.Teacher(3)))
    println(describe(Staff.Worker))
}