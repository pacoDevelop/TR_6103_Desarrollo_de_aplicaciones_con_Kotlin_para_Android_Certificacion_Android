package com.example.kotlinex.poo

interface CourseRepository {
    val isCoursePersisted: Boolean
    fun getById(id:Int):Course

    fun save(course:Course): Int{
        println("Course: $course")
        return course.id
    }
}

interface Repository {
    fun getAll() : Any
}

class SqlCourseRepository : CourseRepository,Repository{
    override val isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
       return Course(
           id,
           "Programación Kotlin Reactiva",
           "Julian Perez"
       )
    }

    override fun getAll(): Any {
        return 1
    }

}

fun main() {
    val sqlCourse=SqlCourseRepository();
    println(sqlCourse.isCoursePersisted)
    println("ID guardado ${sqlCourse.save(sqlCourse.getById(1))}")
    println(sqlCourse.getAll())
}