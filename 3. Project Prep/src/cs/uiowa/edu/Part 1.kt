package cs.uiowa.edu

/*
//the number of vowels in a file
import java.io.FileInputStream
import java.io.BufferedInputStream
import java.io.File

fun fileVowelCount(fname:String):Int {
    var count:Int = 0
    val vowels = setOf('a','e','i','o','u')
    val file = File(fname)
    val b = BufferedInputStream(FileInputStream(file))
    while (b.available() > 0) {
        val c: Char = b.read().toChar()
        if (c.toLowerCase() in vowels) {
            count++
        }
    }
    return count
}
fun main(args: Array<String>) {
    val current = java.io.File(".").canonicalPath
    println(current)
    val floc = "src/demo.kt"
    println(fileVowelCount(floc))
        //266
}
*/

/*
//Counting Lines Which Have Vowels
import java.io.FileReader
import java.io.BufferedReader
import java.io.File

fun lineVowelCount(fname:String):Int {
    var count:Int = 0
    val vowels = setOf('a','e','i','o','u')
    val file = File(fname)
    val b = BufferedReader(FileReader(file))
    do {
        val line = b.readLine() // could be null
        if (line != null)
            for (c:Char in line) {
                if (c.toLowerCase() in vowels) {
                    count++;
                    break
                }
            }
    } while (line != null)
    return count
}
fun main(args: Array<String>) {
    val current = java.io.File(".").canonicalPath
    println(current)
    val floc = "src/demo.kt"
    println(lineVowelCount(floc))
    //48
}*/


//Reading Web Pages
//Counting lines in a Web Page
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun lineVowelCount(place: String): Int {
    var count = 0
    val vowels = setOf('a','e','i','o','u')
    val url:URL = URL(place)
    val inputstream = InputStreamReader(url.openStream())
    val b = BufferedReader(inputstream)
    do {
        val line = b.readLine() // could be null
        if (line != null)
            for (c:Char in line) {
                if (c.toLowerCase() in vowels) {
                    count++;
                    break
                }
            }
    } while (line != null)
    return count
}
fun main(args: Array<String>) {
    println(lineVowelCount("https://www.uiowa.edu"))
        //306 lines that have vowels in it
}