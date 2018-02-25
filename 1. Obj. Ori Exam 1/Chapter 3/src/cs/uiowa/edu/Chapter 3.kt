package cs.uiowa.edu

import org.jetbrains.annotations.Mutable

/*fun main (args: Array<String>){
    val x: List<Int>? //<-- the "?" means that the return of this variable may or may not be null
    val t = mutableMapOf("one" to 1, "Two" to 2)
    val keys = t.keys //keys is the set of all the keys
    //The println shows the origin of the java class
    println("t class is " + t.javaClass)
    println("keys class is " + keys.javaClass)
}*/
//---------------------------------------------------------------
/*fun plus(left: Int, right: Int): Int{
    return left + right
}*/
/*fun plus(left: Int, right: Int = 6): Int{
    // right has a default value of 6 that will take it if
    // there are no arguments given to plus for the "right" value
    // this will work for left too
    return left +right
}
fun main (args: Array<String>) {
    val x = plus(2, 3)
    val y = plus(left=2, right=3)
    val z = plus (right=3, left=2) // this will make it so that right will be 3 even though its in the wrong order
    plus(3)
    println(x)
}*/
//---------------------------------------------------------------
/*fun divide(left:Int, right:Int): Unit{ //"Unit" is the "Void" equivalent to java
    val r = left/right
    return
}
fun foo(): Unit{
    return //will just return and do nothing
}
fun main (args: Array<String>){
    divide(4, 5)
    foo()
}*/
//---------------------------------------------------------------
/*fun String.surround(){
    //Surround current string with quotes
    this = '"' + this + '"'// this won't work since strings are immutable
}*/
//But you can return this
/*fun String.surround(): String{
    return '"' + this + '"' //"this" is the string that is being surrounded
}
fun main (args: Array<String>){
    val test = "Hello World"
    println(test)
    println(test.surround())
}*/
//---------------------------------------------------------------
/*fun String.surround(left:String = "\"",
                    right:String = "\""): String{
    //surround current string with whatever left and right are
    return left + this + right
}
fun MutableList<String>.surround(left: String = "(",
                          right: String = ")"){
    //Set Parenthesis () as the default value
    this.add(0,left) //Puts the surrounding variable "left" at position 0
    this.add(this.size,right)  // puts the surround "right" variable at position size
}
fun main (args: Array<String>) {
    val test = "Hello World"
    val g = mutableListOf("a","b","c")
    g.surround()
    println(g)
    println(test)
    println(test.decapitalize().surround()) //decapitalizes the first word's capital letters
    println(test.surround(left = "&", right = "&"))
}*/

