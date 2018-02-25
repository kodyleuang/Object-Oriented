package cs.uiowa.edu
/*
//Definition of List vararg
fun mydemo(vararg x: String): List<String>{
    println("Class x is from " + x.javaClass)
    println("x.size = " + x.size)
    for(e in x) println("Items in the Array $e")
    println("The list version of x " + x.toList())
    return x.toList()
}
fun main(args: Array<String>){
   val e = listOf("a", "b", "c", "d")
    val r = mydemo(*e.toTypedArray()) // The Star " * " Converts a list into individually typed elements in an array
}*/

//Virtual variable/Extention Example, Squares integers
/*var Int.square: Int
    get() = this*this
    set(z) = println("thank you")
fun main (args: Array<String>){
    val x = 55
    println(x.square)
    x.square = 100
}*/

/* Split Example
Allows you to split on certain characters x.split("k") only splits on the letter k
or you can have it split on empty space x.split(Regex("\s+") <-- one or more white space
 */