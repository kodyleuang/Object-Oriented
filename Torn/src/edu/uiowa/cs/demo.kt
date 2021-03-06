package edu.uiowa.cs

import tornadofx.*

class demo : View("My View") {
    val controller = demoControl()
    override val root = vbox {
        label("Get the string's length")
        val inputval = textfield("a")
        button("Press for length") {
            action {
                controller.someaction(inputval.text)
            }
        }
    }
}

class demoModel : ItemViewModel<demo>() {
    val controller = bind(demo::controller)
    val root = bind(demo::root)
}

class demoControl : Controller() {
    fun someaction(inputval: String) {
        val x = inputval
        val y = x.length.toString()
        println("Length of the string is $y")
    }
}