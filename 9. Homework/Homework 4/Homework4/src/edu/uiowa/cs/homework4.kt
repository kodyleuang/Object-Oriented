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
    //Sorts the numbers lowest to highest
    val b = a.sortedBy { it }
    //Turns the list into a set for use of Pairing later
    val c= b.toSet()
    //Makes a list of lists<Int> with the common numbers grouped together
    val d = b.groupBy { it }.map { it.value }
    //Determines how many times a number occurs in the list
    val e = d.map{ it.sumBy { it }.div(it.first()) }
    //Creates a Pair of where the pair is Pair<Number,Occurrences>
    val f = c.zip(e)
    //Finds the most occurred numbers in the list of Pairs
    val g = f.filter { it.second==e.max() }
    //Takes the first element in a pair (the number with the most occurrences) puts it into a set
    val h = g.map { it.first }.toSet()
    return h
}

fun flatsum(inputlist: List<Any>): Int {
    var sum = 0
    if (inputlist.isEmpty()) return 0
    val numbers = inputlist.filterIsInstance<Int>()
    //If nothing was filtered out add up all the Integers
    if (numbers.size==inputlist.size) {
        sum = numbers.sum()
        return sum
    }
    //Else something was Filtered recursion takes place
    else {
        //Creates a List of the different types of elements in the list
        var list = inputlist.groupBy { it.javaClass.kotlin }.map { it.value }
        //Checks for Strings in the inputlist
        val letters = inputlist.filterIsInstance<String>()
        //if the strings are equal then there does not exist an Int which can be added so return 0
        if(letters.size == inputlist.size) return 0
        //Checks for Lists within the List
        val filtLists = inputlist.filterIsInstance<List<Any>>()
        //If there are List within a List replaces "list" to be able to recurse through that list
        if(filtLists == inputlist) list = filtLists

        sum = list.sumBy { v -> flatsum(v)}
    }
    return sum
}
