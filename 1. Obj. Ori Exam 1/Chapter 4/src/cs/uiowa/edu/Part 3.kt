package cs.uiowa.edu

/*class Person{   //using "Secondary" Constructor syntax
    val name: String
    val Id: Int
    constructor(name:String = "", Id: Int = 0){
        this.name = name
        this.Id = Id
    }
    //constructor(d:Double): this("bob",3)
}

fun main(args: Array<String>) {
    val x = Person("Alfred", 1)
    println(x)
}*/

/*class Person        //using the "PRIMARY" constructor
    constructor(val _name:String, val _Id: Int){
    val name: String
    val Id: Int
            init{
                this.name = _name
                this.Id = _Id
            }
}
fun main(args: Array<String>) {
    val x = Person("Alfred", 1)
    println(x.name)
}*/

//Lazy Way
class Person(val name:String, val Id:Int){
    companion object{       //THIS IS LIKE STATIC METHODS
        fun nameid(p: Person): String{  //There is no "this" there is only individual variables belonging to its own method
            return "${p.name} .. ${p.Id}"
        }
    }
}
fun main(args: Array<String>) {
    val p = Person("Alfred", 1)
    println(p.name)
    val s = Person.nameid(p)
    println(s)
}