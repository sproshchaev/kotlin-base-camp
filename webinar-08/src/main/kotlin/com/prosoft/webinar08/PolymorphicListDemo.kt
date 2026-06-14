package com.prosoft.webinar08

interface Device {
    val name: String
    fun turnOn(): String
}

class Phone : Device {
    override val name = "Телефон"
    override fun turnOn() = "$name включается с экрана"
}

class Laptop : Device {
    override val name = "Ноутбук"
    override fun turnOn() = "$name загружает систему"
}

class Tablet : Device {
    override val name = "Планшет"
    override fun turnOn() = "$name показывает логотип"
}

fun main() {
    val devices: List<Device> = listOf(Phone(), Laptop(), Tablet())
    for (device in devices) {
        println(device.turnOn())   // полиморфный вызов — каждый по-своему
    }
}
// Телефон включается с экрана
// Ноутбук загружает систему
// Планшет показывает логотип