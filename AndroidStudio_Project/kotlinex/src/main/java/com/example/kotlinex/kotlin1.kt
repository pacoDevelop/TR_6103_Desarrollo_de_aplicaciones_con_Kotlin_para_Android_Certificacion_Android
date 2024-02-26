package com.example.kotlinex

open class SuperBoton{
    open fun disable(){
        println("Desabilitando el boton sencillo")
    }
    open fun animate(){
        println("animando sencillo")
    }
}

class BotonReproducir : SuperBoton() {
    override fun disable(){
        println("Deshabilitar play complejo")
        super.disable()
    }
    override fun animate(){
        println("Deshabilitar play complejo")
        super.animate()
    }
}

fun main(){
    println("Todo ok")
    val botonPlay=BotonReproducir()
    botonPlay.animate()
    botonPlay.disable()
}