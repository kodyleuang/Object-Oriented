package edu.uiowa.cs

// these are standard imports for a reader and for web page reading
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun wordsInPage(place: String): Int {
    var count = 0
    val line: String? = null
    val url:URL = URL(place)
    val inputstream = InputStreamReader(url.openStream())
    val reader = BufferedReader(inputstream)
    do {
        val line = reader?.readLine()
        val words = line?.split(Regex("\\s+"))
        val aWords = words?.filter { it.startsWith("a") }

        val size = aWords?.size ?: 0
        count += size

       } while (line != null)
    return count
}

fun main(args: Array<String>) {
    println("\n\nProcessing Page ${args[0]}")
    // println(args.toList()) // for debugging only
    println(wordsInPage(args[0]))

}