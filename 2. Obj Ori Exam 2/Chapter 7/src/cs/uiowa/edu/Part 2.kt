package cs.uiowa.edu

/*
// by keyword
class Holder(
        var names:MutableList<String>
        var echo:Runnable):
        List<String> by names,          //by used
        Runnable by echo {              //by used
    init {
        names = mutableListOf<String>()
        echo = object: Runnable {
            override fun run() {
                println("hello")
            }
        }
    }
}*/

//Observable    takes 2 arguments, and a handler for modifications (something that should get called if it's changed)
//To be continued

//Memoization: optimization technique stores the results of expensive function call
//If you call the function again it gives the answer without having to run the function since it will take a while
//Declare a variable and use the "lazy" keyword to do memoization

/*
//Delegate a property to a class, provided that class has getValue() and setValue() methods
//The "KProperty" is a special interface defined as part of Kotlin's reflection facility,
//which enables limited introspection into objects
import kotlin.reflect.KProperty
class server {
    operator fun getValue(person: Person, property: KProperty<*>): Any {
        val i = persons.indexOf(person)
        return names.get(i)
    }
    operator fun setValue(person: Person, property: KProperty<*>, any: Any) {
        val i = persons.indexOf(person)
        if (i != -1) names[i] = any as String
        else { persons.add(person)
            names.add(any as String)
        }
    }
    companion object {
        val persons = mutableListOf<Person>()
        val names = mutableListOf<String>()
    }
}
class Person(_name:String, _id:Int) {
    var name by server()
    val id: Int
    init { name = _name; id = _id }
}

fun main(args: Array<String>) {
    val p = Person("sven",3078)
    val q = Person("taylor",4145)
    println(server.names)
        //[sven, taylor]
}

//assert statement: x!! makes it so that program will crash if x is null
    /* - assert(x!=null) does the same thing, but essentially says "I WANT my program to crash if x is null"
        rather than "I assure my code x won't be null even if it could be"
     */
*/

/*
//This means it will return a boolean (because it normally returns a boolean)
// the equals sign means return essentially

/* another way of writing it
fun isOdd(x:Int):Boolean{
    return x%2!=0
 */
fun isOdd(x: Int) = x % 2 !=0

fun main(args: Array<String>) {
    println(isOdd(5))
        //true
    val numbers = listOf(1,3,4)
    println(numbers.filter(::isOdd))        //:: can be used with overloaded functions when expected type is given
        //[1,3]
}*/

/*
//Property References
val x = 1

fun main(args: Array<String>){
    println(::x.get())
        //prints "1"
    println(::x.name)
        //prints "x"
}*/

/*
//Deconstruction
class Person(val name:String, val id:Int, val age:Int) {
    operator fun component1() = name
    operator fun component2():Int = id
    operator fun component3():Int = age
}
/* you can use data instead of component for class like this
data class Person(val name:String, val id:Int, val age:Int)
 */

fun main(args: Array<String>) {
    val p = Person("Vin Sam",1078,19)
    val q = Person("Ann Tae", 9872, 20)
    val P = listOf(p,q)
    P.forEach {
        val (a,b,c) = it
        println("a = $a, b = $b, c = $c")
            /*
            a = Vin Sam, b = 1078, c = 19
            a = Ann Tae, b = 9872, c = 20
             */
    }
    println("---------------------------------------------")
    println("Second time, as regular loop")
    for ((i,j,k) in P) println("i = $i, j = $j, k = $k")
        /*
        i = Vin Sam, j = 1078, k = 19
        i = Ann Tae, j = 9872, k = 20
         */
}*/
