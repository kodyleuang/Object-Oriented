package cs.uiowa.edu

//Using infix functions
infix fun Int.plus(y:Int): Int = this+y             //extends the Int class by creating a new function called plus

//Defining a function within a function
fun main(args: Array<String>){
    fun test(a:Int, b:Int){
        val c = a plus b
        println(c)
    }
    test(3, 100)
}