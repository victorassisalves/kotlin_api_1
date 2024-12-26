package alura.study.api.alura.service

import alura.study.api.alura.dto.CourseFormDTO
import alura.study.api.alura.dto.CourseViewDTO
import alura.study.api.alura.mapper.CourseFormMapper
import alura.study.api.alura.mapper.CourseViewMapper
import alura.study.api.alura.model.Course
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CourseService (
    var courses: List<Course> = emptyList(),
    val courseViewMapper: CourseViewMapper,
    val courseFormMapper: CourseFormMapper
) {
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

    fun fetchCourses(): List<CourseViewDTO> {
        return courses.stream().map {
                t -> courseViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun fetchCourseById(id: Long): CourseViewDTO {
        val course = courses.find { it.id == id } ?: throw Exception("Course with ID #$id not found")
        return courseViewMapper.map(course)
}

    fun createCourse(course: CourseFormDTO): CourseViewDTO {
        courses = courses.plus(courseFormMapper.map(course))
        val newCourse = courses.last()
        newCourse.id = courses.size.toLong()-1
        return courseViewMapper.map(newCourse)
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