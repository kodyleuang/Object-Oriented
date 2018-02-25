package edu.uiowa.cs

// There are three functions to be done for this homework
// (but you can add more functions if that helps). Please see
// the test file to understand requirements for these functions

fun oddLengthWords(input:String): List<String> {
    var words = input.split(Regex("\\s+"))
    var oddWords: MutableList<String> = ArrayList<String>()
    for(words in words.listIterator()){
        if(words.length%2!=0) oddWords.add(words)
    }
    return oddWords
}

fun mostCommon(input: Collection<Int>): Set<Int> {
    val newMap = HashMap<Int, Int>()
    val newSet= mutableSetOf<Int>()
    var counter = 1
    for (i in input) {
        if(newMap.containsKey(i)){
            //take the value at the element and add 1
            val x = newMap.get(i)!! +1
            if (counter<x) counter++
            newMap.put(i,x)
        }
        else newMap.put(i, 1)
    }
    for(j in newMap){
        if(counter == j.value) newSet.add(j.key)
    }
    return newSet
}

fun flatsum(inputlist: List<Any>): Int {
    var sum = 0
    for (i in 0..inputlist.size-1) {
        val k = inputlist[i]
        if(k is Int) {
            sum += k
        }
        else if(k is String){
            continue
        }
        else{
            sum += flatsum(inputlist[i] as List<Any>)
        }
    }
    return sum
}

