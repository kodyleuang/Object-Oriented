package cs.uiowa.edu

//Puzzles
/*
open class A {
    open fun x() = println("hello")
}
class B: A() {      //<-- The class A has parameters because it needs it as a constructor A()
    override fun x() = println("bye")
}
fun main(args: Array<String>) {
    val a = B()
    a.x()
    (a as A).x() // Wut ...     //B class cannot be casted into A because the object "a" takes it's stuff with it so prints bye not hello
    val b = A()
    b.x()
    (b as B).x() // Why?        // A does not know that B is it's subclass so it does not work
}
*/

/*
open class A // empty class, but totally legal
class B: A   // why is this an error?
//Because A needs a constructor
*/

/*
open class C(var x:String) // every C object has an x
class D(g:String, val h:Int): C(g)
// every D object is a C, and also has an h
// why doesn't "g" need val or var?
*/

/*
open class C(var x:String) // every C object has an x
class D: C{
    var h:Int
    constructor(g:String, h:Int):super(g){
        this.h=h
    }
}
fun main(args: Array<String>){
    val t = D("Iowa", 1)
    println(t.h)
    println(t.x)
    /*
    >>> 1
    >>>Iowa
     */
}
*/

/*
fun main(args: Array<String>){
    var abcd: Int? = null       //Int? allows it to possibly be null if it's not an Int
    if(abcd == null){}
    else {
        val q = abcd + 5    //You can get passed the null by using an if statement, cannot add null and 5
    }
}
*/
/*Notes on Null
The combinations of null
Int? means it could be a number or null
List?<String> Could be a List or null
List<String?> Is a list may contain strings or null
List?<String?> Could be a list but if it is a list it could have Strings or Null
---------------------------------------------------------------------------
Something to help with Null
"?." : lets you run functions with the possibility of the object being null
 */

/*
//You can do something else other than if statments to get passed null
fun main(args: Array<String>){
    var abcd: Int? = null       //Int? allows it to possibly be null if it's not an Int
    val q = abcd?.plus(5)
    abcd
            ?.magic1("a")       //If abcd is null then it would return null otherwise return a (ignore magic it doesnt mean anything just an example)
            ?.magic2("b")       //Same with magic 2
}
*/

fun main(args: Array<String>){
    val V: Array<Int?> = arrayOfNulls(10)
    val p = java.util.Random()
    for(i in 1..5)V[p.nextInt(10)]=i
    println(V.toList())
    // Prints [4, 3, null, null, null, 2, 5, 1, null, null]
    // 2nd run = [null, 5, null, null, 1, null, null, 3, null, 4] <-- notice there is no #2
}