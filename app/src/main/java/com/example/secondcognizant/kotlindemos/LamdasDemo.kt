package com.example.secondcognizant.kotlindemos

class LamdasDemo {
        fun upperCaseTwo(name: String): String {
            println("myuppercase reference")
            return name.toUpperCase()

    }
}

fun main() {
    // All examples create a function object that performs upper-casing.
    // So it's a function from String to String

    fun upperCaseOne(name:String):String{

        return name.toUpperCase()
    }
   // val uc1: Int
    val upperCase1: (String) -> String = { str: String -> str.uppercase() } // 1

    val upperCase2: (String) -> String = { str -> str.uppercase() }         // 2

    val upperCase3 = { str: String -> str.uppercase() }                     // 3

    // val upperCase4 = { str -> str.uppercase() }                          // 4

    val upperCase5: (String) -> String = { it.uppercase() }                 // 5

    var lamdasDemo:LamdasDemo = LamdasDemo()
    val upperCase6: (String) -> String = lamdasDemo::upperCaseTwo                // 6

    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}