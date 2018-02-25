package edu.uiowa.cs

import tornadofx.*

class demo : View("My View") {
    val controller = demoControl()
    override val root = vbox {
        label(" demo of button and input field ")
        val inputval = textfield("replace this text")
        button("Press Me Button") {
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
        println("someaction got $inputval")
    }
}