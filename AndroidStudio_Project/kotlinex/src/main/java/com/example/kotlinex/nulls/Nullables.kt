package com.example.kotlinex.nulls

class Movie(
    val id: Int?,
    val name: String
    )

fun main() {
    val m1 = Movie(null,"ET")
    var nameNullable :String? = null

    println(nameNullable?.length)

    nameNullable?.let { println("${it.length} A") }
}
