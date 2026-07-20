package com.prosoft.webinar18

// Пример 3. Перегрузка операторов.
// Как научить свой класс работать с привычными знаками: +, [], in, унарный минус.

data class Track(val title: String, val seconds: Int)

class Playlist(val name: String) {
    private val tracks = mutableListOf<Track>()

    val size: Int get() = tracks.size   // обычное свойство, не оператор

    // playlist + track
    operator fun plus(track: Track): Playlist {
        tracks.add(track)
        return this
    }

    // playlist[0]
    operator fun get(index: Int): Track = tracks[index]

    // track in playlist  ->  playlist.contains(track)
    operator fun contains(track: Track): Boolean = tracks.contains(track)

    // for (track in playlist)
    operator fun iterator(): Iterator<Track> = tracks.iterator()
}

// Оператор как функция-расширение: -track разворачивает название
operator fun Track.unaryMinus() = Track(title.reversed(), seconds)

class PlaylistOperatorsDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val playlist = Playlist("Road trip")
            val bohemian = Track("Bohemian Rhapsody", 355)

            playlist + bohemian + Track("Hotel California", 391)   // цепочка
            println("Треков: ${playlist.size}")                     // Треков: 2

            println(playlist[0].title)          // Bohemian Rhapsody  -> get(0)
            println(bohemian in playlist)       // true               -> contains(...)

            for (track in playlist) {           // iterator()
                println("  ${track.title} — ${track.seconds} c")
            }

            println((-bohemian).title)          // ysdohapaR naimehoB  -> unaryMinus()
        }
    }
}
