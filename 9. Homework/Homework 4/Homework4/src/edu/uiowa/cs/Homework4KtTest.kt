package edu.uiowa.cs

import org.junit.Test
import kotlin.test.assertEquals

class Homework4KtTest {

    // The initial tests are for the oddLengthWords function

    @Test
    fun test1() { // mixed test
        assertEquals(listOf("one","two"), oddLengthWords("one\t or two"))
    }
    @Test
    fun test2() { // test with empty input
        assertEquals(oddLengthWords("   \n"),
                ArrayList<String>()
        )
    }
    @Test
    fun test3() { // test with no odd length words
        assertEquals(
           oddLengthWords("even to only"),
                ArrayList<String>())
         }

    // next tests are for mostCommon
    @Test
    fun test4() {
        assertEquals(setOf(3,4),
                mostCommon(listOf(4,1,2,3,4,5,3,3,4)))
    }

    @Test
    fun test5() {
        assertEquals(setOf(100),
                mostCommon(listOf(100,100,1,2,3,100)))
    }

    // the final list of tests is for recursive sum
    @Test
    fun test6() {
        val t = listOf(1,2,listOf(3,4),5,listOf(6,7))
        assertEquals(28,flatsum(t))
    }

    @Test
    fun test7() {
        assertEquals(0,flatsum(listOf(1,-1)))
    }

    @Test
    fun test8() {
        val a = listOf(10,20,30)
        val b = listOf(-10,-20,-30,a)
        val c = listOf(-5,18,2,a,b,listOf(1000,b,b))
        assertEquals(1075,flatsum(c))
    }
}