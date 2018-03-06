package cs.uiowa.edu

fun main(args: Array<String>){
    val k = listOf(1,2,3,4,10,5)
    val l = listOf(1,2,3,4,5,10)
    val g = k.map { it % 2 == 0 }
    val str = "hello"
    val i = "he"
    val b = str.compareTo(i)
    println(b)
    println(g)
}