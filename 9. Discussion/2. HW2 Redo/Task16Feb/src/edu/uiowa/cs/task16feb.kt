package edu.uiowa.cs

import java.util.*

// globally accessible list of binary operators
val arith = listOf("*","/","+","-","%") // arithmetic operators
val compare = listOf("<",">","==",">=","<=","!=") // comparison operators
val logic = listOf("&&", "||") // logic operators

open class Node

open class ValNode:Node()
class IntVal(val value:Int):ValNode()
class BooleanVal(val value:Boolean):ValNode()

open class OpNode(val operator:String):Node()
class UnaryOp(op: String, val child:Node): OpNode(op)
class BinaryOp(op: String, val left:Node, val right:Node):OpNode(op)



// WORK TO DO: DEFINE THESE CLASSES TO MAKE THE CODE 
// COMPILE AND RUN THE TESTS SUCCESSFULLY:
//   Node, ValNode, IntVal, BooleanVal, OpNode, BinaryOp, UnaryOp
// (You need to define seven classes, with Node as ancestor to all others)

// bEint function calculates for a binary operator producing Int
fun bEint(op:String,v1:Int,v2:Int): Int {
    when (op) {
        "*" -> return v1*v2
        "+" -> return v1+v2
        "/" -> return v1/v2
        "-" -> return v1-v2
        "%" -> return v1%v2
        else -> throw Error()
        }
    }
// bEbool function calculates for a binary operator producing Boolean
fun bEbool(op:String,v1:Int,v2:Int): Boolean {
    when (op) {
            ">" -> return v1 > v2
            "<" -> return v1 < v2
            "==" -> return v1 == v2
            "<=" -> return v1 <= v1
            ">=" -> return v1 >= v2
            "!=" -> return v1 != v2
            else -> throw Error()
        }
    }
fun bElogic(op:String,v1:Boolean,v2:Boolean): Boolean {
    when (op) {
            "&&" -> return v1&&v2
            "||" -> return v1||v2
            else -> throw Error()
        }
    }

fun NodeEval(root:Node): Node {
    when (root) {
        is ValNode -> return root
        is UnaryOp -> {
            if (root.operator !in listOf("_", "!")) throw Error()
            val subEval = NodeEval(root.child)
            when (subEval) {
                is IntVal ->
                    when (root.operator) {
                        "_" -> return IntVal(-subEval.value)
                        else -> throw Error()
                    }
                is BooleanVal ->
                    when (root.operator) {
                        "!" -> return BooleanVal(!subEval.value)
                        else -> throw Error()
                    }
                else -> throw Error()
            }
        }
        is BinaryOp -> {
            when (root.operator) {
                in arith -> {
                    val subleft = NodeEval(root.left) as IntVal
                    val subright = NodeEval(root.right) as IntVal
                    val resultop =
                            bEint(root.operator, subleft.value, subright.value)
                    return IntVal(resultop)
                }
                in compare -> {
                    val subleft = NodeEval(root.left) as IntVal
                    val subright = NodeEval(root.right) as IntVal
                    val resultop =
                            bEbool(root.operator, subleft.value, subright.value)
                    return BooleanVal(resultop)
                }
                in logic -> {
                    val subleft = NodeEval(root.left) as BooleanVal
                    val subright = NodeEval(root.right) as BooleanVal
                    val resultop =
                            bElogic(root.operator, subleft.value, subright.value)
                    return BooleanVal(resultop)
                }
            }
        }


    }
    throw Error() // just to make compiler happy
}
