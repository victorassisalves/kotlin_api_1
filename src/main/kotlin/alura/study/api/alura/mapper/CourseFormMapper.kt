package alura.study.api.alura.mapper

import alura.study.api.alura.dto.CourseFormDTO
import alura.study.api.alura.model.Course
import org.springframework.stereotype.Component

@Component
class CourseFormMapper: Mapper<CourseFormDTO, Course> {
    override fun map(course: CourseFormDTO): Course {
        return Course(
            name = course.name,
            category = course.category
        )
    }
}