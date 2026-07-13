package com.prosoft.webinar17

// Пример 7. Лямбда с получателем — основа DSL.
class HtmlBuilder {
    private val lines = mutableListOf<String>()
    fun p(text: String) { lines.add("<p>$text</p>") }
    fun h1(text: String) { lines.add("<h1>$text</h1>") }
    fun build(): String = lines.joinToString("\n")

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val page = html {
                h1("Привет, DSL!")
                p("Это абзац.")
                p("И ещё один.")
            }
            println(page)
        }
    }
}

fun html(block: HtmlBuilder.() -> Unit): String {
    val builder = HtmlBuilder()
    builder.block()
    return builder.build()
}
