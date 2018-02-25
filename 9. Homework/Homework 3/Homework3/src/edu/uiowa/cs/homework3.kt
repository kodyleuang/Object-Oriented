package edu.uiowa.cs

// write code for Disability, Person, Alien, Resident, Adult and Minor
// classes here (unit test cases are in the ClassTest file)
// you may need to adjust the run configuration for ClassTest also

enum class Disability{
    MOBILITY, SIGHT, HEARING, SPEAKING, READING;
}

open class Person{   //using "Secondary" Constructor syntax
    val name: String
    val Id: String
    var disabilities: MutableSet<Disability> = mutableSetOf<Disability>()
    constructor(name:String = "", Id: String = "", disabilities: Disability){
        this.name = name
        this.Id = Id
    }
    //constructor(d:Double): this("bob",3)
}
/*
open class Person (val name:String, val id:String){
    var PersonList = mutableListOf<Person>()
}
*/
open class Resident(name:String, id:String):Person(name, id)
class Adult(name:String, id:String, val disabilities: Disability):Resident(name, id){}
class Minor(name:String, id:String, val disabilities: Disability):Resident(name, id){}

open class Alien(name:String, id:String,var passport: String):Person(name, id){

}