package com.example.kotlinex.collection

class Operations {
}

fun main() {
    val names = listOf("Juan","Maria","Daienala") //Inmutable
    val names2 =names.toMutableList();
    val mutableNames= mutableListOf("Juan","Maria","Daienala") //mutable
    mutableNames.add("pepe")
    val names3 =mutableNames.toMutableList();
    names2.add("PEPE")
    println(names2)
    println(names)
    //conjuntois
    val set= setOf("Juan","maria","Daniela")
    val mutableSet = mutableSetOf("Juan","maria","Daniela")

    mutableSet.add("Marcos")
    println(mutableSet)

    //Diccionarios

    val mapNames = mapOf("111H" to "Jaime", "2222H" to "Silvia")
    val mutableMapNames = mutableMapOf("111H" to "Jaime", "2222H" to "Silvia")
    mutableMapNames["22332H"]="PEPE"
    println(mutableSet)
}