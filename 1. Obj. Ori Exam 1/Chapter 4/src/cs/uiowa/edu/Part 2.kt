package cs.uiowa.edu

//Data lets you print a better looking toString statement
/*data class Person(val name:String, val Id: Int)

fun main(args: Array<String>){
    val a = Person("Ann", 0)
    val b = Person("Tom", 1)
    val c = Person("Kelly", 2)
    println(a)
    println(a.equals(c))
}
//Prints:
/*Person(name=Ann, Id=0)
  false*/*/

//Creating a Constructor for a class can be done like this
/*class Person{
    var name: String = ""
    var Id: Int = 0
    constructor(x:String="",Id:Int=0){
        name = x            //Can make assignments w/o "this" keyword so it's not so confusing or
        this.Id = Id        //You can use "this" so it doesn't get confused with the real Id vs the incoming Id
    }
    constructor(y:Double){
        Person("",y.toInt())
    }
}

fun main(args: Array<String>){
    val a = Person("Ann", 0)
    val b = Person("Tom", 1)
    val c = Person("Kelly", 2)
    println(a)
    println(a.equals(c))
}*/

//Another Constructor example, Open means it is not final, all classes are final by default in Kotlin
/*open class User{
    var name: String = ""
    constructor(_name:String){
        println("User constructed $_name")
        this.name = _name
    }
}*/
//In fact User is not even needed sort of
//Kotlin will make the constructor for the super for you example above not needed
/*open class User(val name:String){
}
class NumberedUser: User{           //This class extends User the ":" colon means extends the class, Can even extend Interfaces
    var Id: Int = 0
    constructor(_name:String, _Id:Int): super(_name){    //you need to call Super() so that it can use it's constructor before the extension does their constructor
                                        //^^^^^ The _name that is given to NumberedUser class gets passed to the super so it can do the work
        this.Id = _Id
    }
}
fun main(args: Array<String>) {
    val a = NumberedUser("Ann", 0)
    println(a)
        /*User constructed Ann
          cs.uiowa.edu.NumberedUser@266474c2*/

}*/
//Part 2 of above
open class User(val name:String){       //This class is empty see line 47
}
class NumberedUser: User{           //This class extends User the ":" colon means extends the class, Can even extend Interfaces
    var seecount = 0
    var Id: Int
        get() = 500
        set(p:Int){
            seecount += 1
            field = p      //When writing a setter you will be stuck in an infinite loop unless you use "field" instead of "Id"
        }
    constructor(_name:String, _Id:Int): super(_name){    //you need to call Super() so that it can use it's constructor before the extension does their constructor
        //^^^^^ The _name that is given to NumberedUser class gets passed to the super so it can do the work
        this.Id = _Id
    }
}
fun main(args: Array<String>) {
    val a = NumberedUser("Ann", 0)
    a.Id = 75
    a.Id += 100
    println(a.name + " " + a.Id + " " + a.seecount)
        //Ann 500 3
}