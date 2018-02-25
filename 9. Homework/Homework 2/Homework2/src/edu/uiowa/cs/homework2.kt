package edu.uiowa.cs

import java.util.*

// globally accessible list of operators:
//  anywhere in your code you can use an expression like
//      if (mystr in operators)
//  to determine whether mystr is one of the known operators
val operators = listOf("*","/","+","-","%","_", // arithmetic operators,
        // _ is unary (means minus, as in 6 + _3)
        "<",">","==",">=","<=","!=", // comparison operators
        "&&", "||", "!" // logic operators, ! is unary
        )

// Tree class: each object is a tree node
data class Tree(var value:Any, var left:Any, var right:Any)

// uE function calculates for a unary operator
fun uE(op:String,v:Any): Any {
    when (op) {
       "_" -> if (v is Int) return -v
       "!" -> if (v is Boolean) return !v
       }
    throw Error()
    }
// bE function calculates for a binary operator
fun bE(op:String,v1:Any,v2:Any): Any {
    if (v1 is Int && v2 is Int)
        when (op) {
            //Mathematical operators
            "*" -> return v1*v2
            "/" -> return v1/v2
            "+" -> return v1+v2
            "-" -> return v1-v2
            "%" -> return v1%v2

            //Boolean operators
            "<" -> return v1<v2
            ">" -> return v1>v2
            "==" -> return v1==v2
            ">=" -> return v1>=v2
            "<=" -> return v1<=v2
            "!=" -> return v1!=v2
        }
    throw Error()
}

/* TreeEval takes a tree and returns a new tree by
   "reducing" the original tree to a single node that
   has no children and a value that is either
   an Int or a Boolean; if the root parameter is
   something like Tree(10,Unit,Unit) then there is
   nothing to reduce, so just return root*/
fun TreeEval(root:Tree): Tree {
    if (root.left==Unit && root.right==Unit){
        return root
    }
    else if(root.value in operators){
        val x = TreeEval(root.left as Tree)
        return if(root.right != Unit) {
            val y = TreeEval(root.right as Tree)
            val z = bE(root.value as String, x.value, y.value)
            Tree(z,Unit,Unit)
        }
        else {
            val z = uE(root.value as String,x.value)
            return Tree(z,Unit,Unit)
        }
    }
    throw Error()
}

// TreeBuild takes a list like [*, +, 2, 3, + 4, 5]
// and returns a Pair: the first thing in the Pair
// is a tree, the second thing is a substring of
// the input which is the part of the input not yet
// examined by this call to TreeBuild. For example,
// if the input is [>= 37 92 && < -4 100] then the
// the returned value would be
//   Pair(Tree(">=",37,92),listOf("&&","<",-4,100))
fun TreeBuild(input:List<Any>): Pair<Tree,List<Any>> {
    if(input[0] !in operators){
        val a = Tree(input.first(),Unit,Unit)
        val remainder = input.drop(1)
        return Pair(a,remainder)
    }
    else if(!input[0].equals("_")&&!input[0].equals("!")){    //Only runs for operators with 2 values
        val op = input.first()          // Takes the operator from the list
        val remainder = input.drop(1)       //Stores the remaining list needed to be processed
        val (a,b) = TreeBuild(remainder)    //Recursively calls the first operand of the list
        val (x,y) = TreeBuild(b)            //Recursively calls the second operand of the list
        val k = Tree(op,a,x)
        return Pair(k,y)        //Returns the Built tree and the rest of the list
    }
    else{
        val op = input.first()                  //Takes the Operator of a Unary operator
        val remainder = input.drop(1)    //Stores the remaining list needed to be processed
        val newTree = TreeBuild(remainder)      //Recursively calls the rest of the list
        val x = Tree(op,newTree.first,Unit)         //Creates a Tree for the Unary Operator
        return Pair(x,newTree.second)
    }

    throw Error()
}

