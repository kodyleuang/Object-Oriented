package cs.uiowa.edu

/*
class A(val p:String)
fun table(a:String,b:Int): String {
    return Array<String>(b,{a}) // creates [a,a,a,a,a,a...a] (b times)
            .joinToString() }
fun main(args: Array<String>) {
    val test = "go hawks this year".split(' ')
        //[go, hawks, this, year]
    val n = A::p  // textbook way to reference property of an object Class A with variable P
    val M = test.map { A(it) } // create list of A objects
    val O = M.map { n(it) } // list of the p property of each A obj
    println(O); println("\n----------\n")
    val m = ::table  // like a lambda wrapper for table()
    // BECAUSE YOU CANNOT PASS table() AS A PARAMETER!
    // (of course m is not used as a parameter but it could be
    // in more complex programs)
    val R = test.map { m(it,it.length) }
    println(R)
        //[go, go, hawks, hawks, hawks, hawks, hawks, this, this, this, this, year, year, year, year]
}*/

/*
class A { // class is named A
    companion object B {  // companion B
        fun f(x:Int): Int {
            return x*x
        }
    }
}
fun main(args: Array<String>) {
    val T = listOf(3,4,5,6,7,8)
    val S = T.map { (A.B :: f)(it) }    //Notice this Lambda Expression
    println(S)
        //[9, 16, 25, 36, 49, 64]
}*/

/*
//Flatten Method
fun main(args: Array<String>) {
    val L = listOf(listOf(1,2),listOf(2,4,5))
    println(L) // prints [[1,2],[2,4,5]]
    val M = L.flatten()
    println(M) // prints [1,2,2,4,5]
}*/

/*
//Flat Map Method
fun main(args: Array<String>) {
    val L = mapOf("One" to 1, "Two" to 2, "Three" to 3)
    println(L) // prints {One=1,Two=2,Three=3}
    val M = L.flatMap { it.toPair().toList() }      //flatMap needs a Lambda, changes to a pair then a list
    println(M) // prints [One,1,Two,2,Three,3]
}*/

/*
//groupBy Method
fun main(args: Array<String>) {
    val L = """here we have a list
            of words with possibly different
            lengths and even words that might repeat"""     //Triple quotes to use multiline instead of one
            .split(Regex("\\s+"))       //Splits by all white spaces
    val M = L.groupBy { word:String -> word[0] }        // groupBy method groups the words by the first letter (in this case) word[0]
    println(M) // M is a map
    // prints {h=[here, have], w=[we, words, with, words],
    // a=[a, and], l=[list, lengths], o=[of], p=[possibly],
    // d=[different], e=[even], t=[that], m=[might], r=[repeat]}
    val N = M.map { Pair(it.key,it.value.size) }        //Changes it into a pair
    println(N)
    // prints [(h, 2), (w, 4), (a, 2), (l, 2), (o, 1), (p, 1),
    // (d, 1), (e, 1), (t, 1), (m, 1), (r, 1)]
    val D = N.toMap()       // changes it into a map
    // prints {h=2, w=4, a=2, l=2, o=1, p=1,
    //         d=1, e=1, t=1, m=1, r=1}
    println(D)
}*/


//Zip method
fun main(args: Array<String>) {
    val a = listOf(10,20,30,40)
    val b = "one two three four".split(' ')
    val c = a.zip(b)        //with zip() you can merge two lists of the same size into a single list of pairs:
    println(c)
    // prints [(10, one), (20, two), (30, three), (40, four)]
}

/*
//sortedBy() method
fun main(args: Array<String>) {
    val s = "here are some words in a row".split(' ')
    val g = s.sortedBy{it.length}
    println(g)
    //[a, in, are, row, here, some, words]
}*/

/*
//Lazy collection (sequences
import java.lang.Math.*
import kotlin.coroutines.experimental.buildSequence
// this is pretty advanced - not in textbook
fun fibonacci() = buildSequence {
    var terms = Pair(0, 1)
    while(true) {
        yield(terms.first) // like return but doesn't return
        terms = Pair(terms.second, terms.first + terms.second)
    }
}
fun main(args: Array<String>) {
    val bignums = generateSequence(100) { it + 1 }      //generateSequence does 2 things, where you want to start goes infinitely
    // bignums is like an infinite sequence 100, 101, 102, ...
    val smallnums = bignums.takeWhile { it < 500 }      //Will do the generate sequence (bignums) up until specified (500)
    // smallnums is finite, just 100, 101, ... 499
    println(smallnums.sum())
        //119800
    val fib = fibonacci().asSequence<Int>()
    val first10 = fib.take(10).toList()
    println(first10)
        //[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
}*/

/*
fun main(args: Array<String>) {
    val L = listOf(5,"hello",6,7,"table")
    val numsInL = L.filterIsInstance<Int>()
    println(numsInL)
    //[5, 6, 7]
}*/