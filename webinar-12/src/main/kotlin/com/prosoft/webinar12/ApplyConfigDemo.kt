package com.prosoft.webinar12

data class Musician(
    var name: String,
    var instrument: String = "",
    var band: String = ""
)

class ApplyConfigDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val m = Musician("Jonny Greenwood")
                .apply {
                    instrument = "Guitar"   // это m.instrument — this опущен
                    band = "Radiohead"      // это m.band
                }
            println(m)
            // Musician(name=Jonny Greenwood, instrument=Guitar, band=Radiohead)
        }
    }
}
