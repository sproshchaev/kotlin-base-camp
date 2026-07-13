package com.prosoft.webinar17

// Пример 12. Аннотация @Suppress — метаданные для компилятора/IDE.
@Suppress("unused")
class AnnotationDemo {

    @Suppress("CanBeVal")
    fun run() {
        var message = "IDE обычно предлагает заменить var на val здесь"
        println(message)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AnnotationDemo().run()
            println("Аннотация @Suppress подавила предупреждения компилятора/IDE")
        }
    }
}
