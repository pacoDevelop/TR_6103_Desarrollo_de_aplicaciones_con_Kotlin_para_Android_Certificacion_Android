package com.example.kotlinex.collection


fun doblar(x:Int): Int{
    return x+x
}
fun calculate(x:Int,y : Int, op:(x:Int,y:Int) ->Int):Int
{
   return op(x,y)
}

fun main() {
    println({x:Int->x+x}(2)); //lambda
    println({ //Multilinea
        x:Int, y:Int ->
        println("Hola")
        println({z : Int -> z+z }(x))
        x+y
    }(2,3))

    val resultadoCaldulate =calculate(22,3,{a,b -> a + b})

    println(resultadoCaldulate)

    val resultadoCaldulate2 =calculate(22,3) { a, b -> a - b }
    println(resultadoCaldulate2)
}
