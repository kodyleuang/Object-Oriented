package cs.uiowa.edu
/*
//Elvis Operator
fun eqshow(v: String?): Boolean {
    return (v ?: 2) == (if (v==null) 2 else v)
}
fun main(args: Array<String>) {
    println(eqshow(null))
    println(eqshow("Hello"))
}
/*
    >>>true
    >>>true
 */
*/

/*
fun ox(K: List<String?>?, b:Int?): String? {
    val r: List<String?> = K ?: listOf("")
    val c = b ?: r.size
    if (c >= r.size) return null
    val e = r[c]
    return e
    // Puzzle - can ox be written in one line?
}
fun main(args: Array<String>) {
    var test: List<String?>? = null
    println(ox(test,2))
    test = listOf("Hello",null,null,"World")
    println(ox(test,3))
    println(ox(test,1))
}

/*
    >>>null
    >>>World
    >>>null
*/
*/

/*
//if x happens to be null use the ?.
fun average(x:Array<Int>?): Int? {
    return x?.sum()?.div(x?.size)       //<-- Notice that it is not x?.sum()/x?.size
    // notice safe call works on properties
}
fun main(args: Array<String>) {
    println(average(arrayOf(4,4,6,6)))
        //5
    println(average(null))
        //null
}
*/
/*
fun main(args: Array<String>) {
    val x: String? = null
    //crashes if it is a null, basically assures the code that it won't be a null even if it could be
    println(x!!.length)
    //error
    val y:String? = "four"
    println(y!!.length)
    //4
}
*/

/*
open class A
class B: A()

fun main(args: Array<String>) {
    val z = A()
    (z as B).toString()
    val x: String? = "five"
    println(x!!.length)
    //error cannot cast A to B
}
*/