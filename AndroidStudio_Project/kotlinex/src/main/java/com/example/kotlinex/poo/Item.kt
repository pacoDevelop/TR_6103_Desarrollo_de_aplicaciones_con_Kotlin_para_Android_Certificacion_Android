package com.example.kotlinex.poo

class Item() {
    var name: String = ""
    var price: Double = 0.0
        get() {
            println("Dentro del getter")
            return field
        }
        set(value) {
            if (value >= 0.0) {
                println("Dentro del setter")
                field = value
            } else {
                throw IllegalArgumentException("No son validos valores negativos")
            }
        }

    constructor(_name: String) : this() {
        name = _name
    }


}

fun main() {
    val item1 = Item("Samsung")
    println(item1)
    item1.name = "Samsung galaxy"
    //item1.price=-0.1
    item1.price=0.1
    println(item1.price)
}