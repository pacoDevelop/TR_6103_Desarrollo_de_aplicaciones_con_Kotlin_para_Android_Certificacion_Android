package com.example.kotlinex.poo

data class Course(
    val id: Int,
    val name: String,
    val author: String,
    //val courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
    var courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
)

enum class CourseCategory {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

fun main() {
    val course = Course(
        1,
        "Programación retiva Kotlin",
        "Juan Lopez"
    )
    val course2 = Course(
        2,
        "Programacion POO Kotlin",
        "Juan Lopez"
    )
    val course3 = course2.copy(id = 3, author = "Maria Lopez")

    val marketingCourse = Course(4, "Instagram Adds", "Maria Lopez", CourseCategory.MARKETING)

    println(course)
    println(course2)
    println(course3)
    println(marketingCourse)
}