package cs.uiowa.edu

// have a class within a constructor that is only used for that class
// B x = new B( { ... (Some class in here) } )

/* Action oriented programing has an action listener that waits for some action to be performed to activate
the action listener to be able to run
 */

/* how do you create an instance of an interface using a lambda

 */

/*
// Answers to quiz
fun main(args: Array<String>) {
    val vng  = listOf("one","Two","three")
    val s = vng.sumBy { it.length }
    println(s)      //11
    // or
    val t = vng.map{it.length}.sum()
    println(t)      //11
    //---------------------------------------------
    val axm = listOf("one","Two","why", "three","why","four")
    val b = axm.filter{it!="why"}.joinToString ()
    println(b)      //one, Two, three, four
}*/


//Using with operator
fun main(args: Array<String>) {
    val J = mutableListOf(10,20,30,35)
    with (J) { // weird syntax here ...
        for (i in 0..100) { if (i%5==0 || i%3==0) add(i) }  //the add here is also j.add(i)
        add(200)        //it makes it so this is really j.add(200)
        for (k in 300..500) { if (k%40 == 0) add(k) }   //Same here j.add(k)
    }
    println(J)
        //[10, 20, 30, 35, 0, 3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30, 33, 35, 36, 39, 40,...
}