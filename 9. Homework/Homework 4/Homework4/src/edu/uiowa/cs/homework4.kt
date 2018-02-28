package edu.uiowa.cs

// Homework4 is the same as Homework1, except that the functions
// should NOT have any loops (for, do, or while) and also the
// program should not use the forEach() method, which is essentially
// another way to write a loop

fun oddLengthWords(input:String): List<String> {
    //creates a list of strings of the words from input using split method
    val words: List<String> = input.split(Regex("\\s+"))
    //Filters the words by taking the length modulus 2 to find odd numbered words
    val odd = words.filter { it.length % 2 == 1 }
    return odd
}

fun mostCommon(input: Collection<Int>): Set<Int> {
    val a = input.toList()
    val b = a.sortedBy { it }
    val c= b.toSet()
    //makes a list of lists with the common numbers grouped together
    val d = b.groupBy { it }.map { it.value }
    //Determines the number of occurrence a number show up
    val e = d.map{ it.sumBy { it }.div(it.first()) }
    val f = c.zip(e)
    //Finds the most occurred numbers in the list of Pairs
    val g = f.filter { it.second==e.max() }
    val h = g.map { it.first }.toSet()
    return h
}

fun flatsum(inputlist: List<Any>): Int {
    // this problem can't be solved without recursion, so the challenge
    // is to use just one recursive call to flatsum(); the trick is
    // to use the filterIsInstance<T>() method, where T is the type of
    // item to be selected; the sum() method is also handy

    // for convenience, the "base case" (first line of function) is
    // given to you

    if (inputlist.isEmpty()) return 0
    return 0
}
