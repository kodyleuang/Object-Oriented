package edu.uiowa.cs

import org.junit.Assert.*
import org.junit.Test

class NodeTest {
    @Test
    fun test1() {
        val r = NodeEval(IntVal(7)) as IntVal
        assertEquals(7,r.value)
    }
    @Test
    fun test2() {
        val tt = BinaryOp("+", IntVal(2), IntVal(10))
        val r = NodeEval(tt) as IntVal
        assertEquals(12,r.value)
    }
    @Test
    fun test3() {
        val tt = BinaryOp("*",IntVal(2),IntVal(10))
        val r = NodeEval(tt) as IntVal
        assertEquals(20,r.value)
    }
    @Test
    fun test4() {
        val tt = BinaryOp("-",IntVal(2),IntVal(10))
        val r = NodeEval(tt) as IntVal
        assertEquals(-8,r.value)
    }
    @Test
    fun test5() {
        val tt = BinaryOp("*",
                BinaryOp("+",IntVal(100),IntVal(-50)),
                UnaryOp("_",IntVal(2)))
        val r = NodeEval(tt) as IntVal
        assertEquals(-100,r.value)
    }
    @Test
    fun test6() {
        val s1 = BinaryOp("/",IntVal(12),IntVal(4))
        val s2 = BinaryOp("-",IntVal(10),IntVal(7))
        val tt = BinaryOp("==",s1,s2)
        val r = NodeEval(tt) as BooleanVal
        assertEquals(true,r.value)
    }
}