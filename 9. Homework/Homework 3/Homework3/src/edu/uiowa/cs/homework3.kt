package edu.uiowa.cs

enum class Disability {
    MOBILITY, SIGHT, HEARING, SPEAKING, READING
}

open class Person {
    val name: String
    val id: String
    var disabilities = setOf<Disability>()
    constructor(_name: String, _id: String) {
        name = _name
        id = _id
        //Checks to see if the ID is a valid length
        for (d in id.toCharArray()) {
            if (d !in "0123456789") throw Error()
            if (id.length != 9) throw Error()
        }
        //Checks for duplicate ID's
        for (a in PersonList) {
            if (id == a.id) throw Error()
        }
        if (name.isBlank()) throw Error()
        if (name.trim { it == ' ' } != name) throw Error()
        PersonList.add(this)
    }
    companion object {
        val PersonList = mutableListOf<Person>()
    }
}
class Alien: Person {
    val passport: String

    constructor(name: String, id: String, _passport: String)
            : super(name, id) {
        passport = _passport
        if (passport.isBlank()) throw Error()
    }
}
open class Resident(name:String,id:String): Person(name,id)
class Adult(name:String,id:String): Resident(name,id) {
    var email: String? = null
    var address: MutableList<String>? = null
        set(t:MutableList<String>?) {
            field = t?.toMutableList()
        }
    fun setAddress(adr: String) {
        address = adr.split("\n").toMutableList()
    }
}
class Minor: Resident {
    var guardian: Person
    constructor(name:String,id:String,guardian:Person): super(name,id) {
        this.guardian = guardian
        if (guardian is Minor) throw Error()
    }
}