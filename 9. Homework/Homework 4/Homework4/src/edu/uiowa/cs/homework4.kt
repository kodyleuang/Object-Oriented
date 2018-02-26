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
    /* this is a hard problem -- to solve this, you should
    create a number of variables, where each variable is assigned
    by collection methods (some use lambdas) applied to input
    and/or previously assigned variables: the idea is to solve
    this problem in series of steps, each getting you further
     progress to the solution; recommended is to print each
    variable during debugging.

    in a sample solution, these were the collection methods used:
    toList(), map(), sum(), zip(), toSet(), sortedBy(), filter()
    */

    return emptySet()
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
