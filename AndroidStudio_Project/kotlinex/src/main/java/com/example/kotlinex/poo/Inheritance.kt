package com.example.kotlinex.poo

open class User(val name: String) {
  //data
   protected var isloggedIn: Boolean = false
    //private var isloggedIn: Boolean = false


    //comportamiento
    open fun login(){
        println("User login")
    }

    open fun logout(){
        println("User logout")
    }
}
class Student(name:String): User(name){
    override fun login(){
        super.login()
        isloggedIn= true
        println("User login student")
        println(isloggedIn)
    }

    override fun logout(){
        super.logout()
        isloggedIn= false
        println("User logout (Student)")
        println(isloggedIn)
    }
}

fun main(){
 val estudiante1 = Student("pepe")
    estudiante1.login()
    //estudiante1.isloggedIn=true
    //println(estudiante1.isloggedIn)
    estudiante1.logout()
    //estudiante1.isloggedIn=false
    //(estudiante1.isloggedIn)

}