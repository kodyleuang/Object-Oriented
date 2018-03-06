package cs.uiowa.edu

import com.sun.org.apache.xpath.internal.operations.Bool

//Kotlin Puzzles
/*
open class A {
    open fun x() = println("hello")
}
class B: A() {
    override fun x() = println("bye")
}
fun main(args: Array<String>) {
    val a = B()
    a.x()
    (a as A).x() // Wut ...
    val b = A()
    b.x()
    (b as B).x() // Why?
}*/


//CompareTo operation example
class Person(val name: String, val Id: Int):
        Comparable<Person>{
    override fun hashCode(): Int{
        return name.hashCode() + Id.hashCode()
    }
    override fun equals(other:Any?):Boolean{
        if(other === this) return true          //Notice "===" means if the objects are pointing to the same thing then it's true
        if(other !is Person)return false
        return name == other.name && Id == other.Id
    }
    override fun compareTo(other: Person): Int =
            when {
                name == other.name && Id == other.Id -> 0
                name == other.name && Id < other.Id -> -1
                name < other.name -> -1
                name == other.name && Id > other.Id -> 1
                name > other.name -> 1
                else -> 1
            }

    override fun toString(): String =
            "Person[$name,$Id]"
}

fun main(args: Array<String>) {
    val p = Person("Gary",23)
    val q = Person("Diane", 91)
    val r = Person("Gary",23)
    val M: Set<Person> = setOf(p,q,r)
    println(M)
        //[Person[Gary,23], Person[Diane,91]]
    val T = listOf(p,r,q).sorted()
    println(T)
        //[Person[Diane,91], Person[Gary,23], Person[Gary,23]]
}

/*
//Delegation Example
class PersonRegistry {
    var M = mutableMapOf<String,Any>()
    var name: String by M       // makes an element name into M as the <String> half
    var id: Int by M            // makes the element id into M as the <Any> half
}
fun main(args: Array<String>) {
    val P = PersonRegistry()
    P.name = "Sven"             //Fills in name in PersonRegistry() class
    P.id = 3078                 //Fills in id in PersonRegistry() class
    println(P.M)
        //{name=Sven, id=3078}
    P.name = "jin"
    P.id = 34
    println(P.M)
        //{name=jin, id=34}
        //This means it replaces the original P.M list so it Will Not have more than one element
}*/