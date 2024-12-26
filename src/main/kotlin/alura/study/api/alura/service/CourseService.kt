package alura.study.api.alura.service

import alura.study.api.alura.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService (var courses: List<Course> = emptyList()) {
    init {
        val course1 = Course(
            id = 0,
            name = "Kotlin",
            category = "Programming"
        )

        val course2 = Course(
            id = 1,
            name = "Java",
            category = "Programming"
        )

        val course3 = Course(
            id = 2,
            name = "Spring Boot",
            category = "Framework"
        )
        courses = listOf(course1, course2, course3)
    }

    fun fetchCourses(): List<Course> {
        return courses
    }

    fun fetchCourseById(id: Long): Course {
    return courses.find { it.id == id } ?: throw Exception("Course with ID #$id not found")
}

    fun createCourse(course: Course): Course {
        courses = courses.plus(Course(
            id = courses.size.toLong(),
            name = course.name,
            category = course.category
        ))
        return courses.last()
    }

//    fun updateCourse(course: Course) {
//        courses = courses.map { if (it.id == course.id) course else it }
//    }
//
//    fun deleteCourse(id: Long) {
//        // Remove course from list
//        courses = courses.filter { it.id != id }
//    }
}