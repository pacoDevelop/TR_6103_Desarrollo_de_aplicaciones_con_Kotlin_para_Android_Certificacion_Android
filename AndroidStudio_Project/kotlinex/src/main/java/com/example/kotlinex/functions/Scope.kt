package com.example.kotlinex.functions

import com.example.kotlinex.poo.Course
import com.example.kotlinex.poo.CourseCategory


fun main() {
    //let
    exploreLet()

    //apply
    explorerApply()
}

fun explorerApply() {
    val courseCategory =""
   val course= Course(1,"Java","Romero").apply {
       this.courseCategory =CourseCategory.BUSINESS
       println("Si")
   }
}

fun exploreLet() {
    val numbers= mutableListOf(null,2,3,4,5)
    val result=numbers.map { it?.times(2) ?: 0 }.filter { it > 5 }.let {
        println(it)
        it.sum()
    }
    println(result)
}
