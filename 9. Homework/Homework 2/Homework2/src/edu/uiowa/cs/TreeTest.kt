package edu.uiowa.cs

import org.junit.Assert.*
import org.junit.Test

class TreeTest {
    @Test
    fun test1() {
        assertEquals(7,TreeEval(Tree(7,Unit,Unit)).value)
    }
    @Test
    fun test2() {
        val tt = Tree("+",
                Tree(2,Unit,Unit),
                Tree(10,Unit,Unit))
        assertEquals(12,TreeEval(tt).value)
    }
    @Test
    fun test3() {
        val tt = Tree("*",
                Tree(2,Unit,Unit),
                Tree(10,Unit,Unit))
        assertEquals(20,TreeEval(tt).value)
    }
    @Test
    fun test4() {
        val tt = Tree("-",
                Tree(2,Unit,Unit),
                Tree(10,Unit,Unit))
        assertEquals(-8,TreeEval(tt).value)
    }
    @Test
    fun test5() {
        val tt = Tree("*",
                Tree("+",
                        Tree(100,Unit,Unit),
                        Tree(-50,Unit,Unit)),
                Tree("_",
                  Tree(2,Unit,Unit),
                        Unit))
        assertEquals(-100,TreeEval(tt).value)
    }
    @Test
    fun test6() {
        val s1 = Tree("/",
                Tree(12,Unit,Unit),Tree(4,Unit,Unit))
        val s2 = Tree("-",
                Tree( 10,Unit,Unit),Tree(7,Unit,Unit))
        val tt = Tree("==",s1,s2)
        assertEquals(true,TreeEval(tt).value)
    }

    @Test
    fun test10() {
        assertEquals(Tree(7,Unit,Unit),TreeBuild(listOf(7)).first)
    }
    @Test
    fun test11() {
        val inl = listOf("+",2,3)
        val tou = Tree("+",
                Tree(2,Unit,Unit),
                Tree(3,Unit,Unit))
        assertEquals(tou,TreeBuild(inl).first)
    }
    @Test
    fun test12() {
        val inl = listOf("*","+",2,3,"_",4)
        val tou = Tree("*",
                Tree("+",
                   Tree(2,Unit,Unit),
                   Tree(3,Unit,Unit)
                   ),
                Tree("_",
                   Tree(4,Unit,Unit),
                   Unit
                   )
                )
        assertEquals(tou,TreeBuild(inl).first)
    }
}