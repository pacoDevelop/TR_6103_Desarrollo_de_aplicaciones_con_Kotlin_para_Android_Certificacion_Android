package com.example.kotlinex.poo

class Person(
    val name: String = "",
    val age: Int = 0
) {
    var email: String = ""
    var nameLenght: Int = 0

    //init

    init {
        println("Bloque init")
        nameLenght = name.length
    }

    //Constructor secundario
    constructor(
        _email: String,
        _name: String,
        _age: Int = 0
    ) : this(_name, _age) {
        email = _email
    }
}

fun main() {
    val person1 = Person("Alex", 0)
    val person2 = Person("maria@gmail.com", "Maria", 21)
}