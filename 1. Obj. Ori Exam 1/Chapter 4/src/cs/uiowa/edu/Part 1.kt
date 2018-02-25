package cs.uiowa.edu

//A function that returns a pair
fun gettwo(p:List<String>): Pair<String,List<String>>{
    val a = p.first()       //Gets the first element in a list
    val b = p[1]
    val c = a+b             // Does a concatination of the first 2 strings
    val remainder = p.drop(2)           //2 elements already used so drop them
    return Pair(c,remainder)       //Returns the pair needed
}

fun main(args: Array<String>){
    val sample = listOf("one", "two", "three", "four")
    val x = gettwo(sample)
    print(x)
    //val a = x.first                 //first is the explictly named first of a pair
    //val b = x.second            //second is the explicitly named second pair
    //val (a,b) = x
    //val (a,b) = gettwo(sample)
}