package cs.uiowa.edu

/*
//Wrapper Example for Lambda Expression
fun main(args: Array<String>){
    val M = mapOf("a" to 1, "b" to 2, "c" to 3)
    //M.forEach({s:String, t:Int ->println(p)})
         /*a
         b
         c*/
    M.forEach   {p->println(p)}     //does the same thing
        /*a=1
        b=2
        c=3*/
}*/

/*
fun main(args: Array<String>) {
    val V = Array<Int>(10, { y -> 1 } )
    println(V.toList())
        //[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]        <- creates 10, 1's
    val W = ArrayList<Int>()
    V.forEach( { y -> W.add(2*y) } )
    println(W)
        //[2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
    V.forEach { y -> W.add(3*y) }
    println(W)
        //[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]
    V.forEach { W.add(5*it) }
    println(W)
        // [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
}*/

/*
data class Person(var name:String, var id:Int)

fun main(args: Array<String>) {
    val p = Person("Amy", 200)
    var s = setOf(p)
    s.forEach {println(it)}
        //Person(name=Amy, id=200)
    s.forEach {println(it.name)}
        //Amy
    val q = Person("Ike",300)
    s = setOf(p,q)
    s.forEach { println(it) }
        /*Person(name=Amy, id=200)
          Person(name=Ike, id=300)*/
}*/

/*
class A{
    companion object{
        fun square(x:Int): Int = x*x
    }
}

fun main(args: Array<String>) {
    val G = listOf(1,2,3,4,5,6)     //<-- in order to use forEach you must have a collection of some sort
    G.forEach { A.square(it) }      //<- A is Class A which calls the square function
}*/

/*
class A {
    fun square(x: Int): Int {
        println(x*x)
        return x * x
    }
}
fun main(args: Array<String>) {
    val G = listOf(1,2,3,4,5,6)     //<-- in order to use forEach you must have a collection of some sort
    /*println(G.map { it*it })
        //[1, 4, 9, 16, 25, 36]*/
    /*println(G.filter{ it%2 == 1})
        //[1, 3, 5]
     */
}*/

/*
//takes an array "this" converts it  a list, converts it to map, then back into an array
fun main(args: Array<String>) {
    val V = Array<Double>(100, { index -> index.toDouble() })
    fun Array<Double>.negate(): Array<Double> {
        return this
                .toList()  // Array's don't have map(), so convert first
                .map { 0.0 - it }  // use the "it" keyword for each item
                .toTypedArray() // convert back to an array
    }
    val Demo = V.negate()
    println(Demo.toList())
    //[0.0, -1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0, -11.0,...
}*/