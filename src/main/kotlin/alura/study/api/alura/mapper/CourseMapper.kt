package alura.study.api.alura.mapper

import alura.study.api.alura.dto.CourseFormDTO
import alura.study.api.alura.dto.CourseViewDTO
import alura.study.api.alura.model.Course
import org.springframework.stereotype.Component

@Component
class CourseMapper: MapperConfig<CourseFormDTO, Course> {
    override fun map(course: CourseFormDTO): Course {
        return Course(
            name = course.name,
            category = course.category
        )
    }
}

@Component
class CourseViewMapper: MapperConfig<Course, CourseViewDTO> {
    override fun map(t: Course): CourseViewDTO {
        return CourseViewDTO(
            t.id,
            t.name,
            t.category
        )
    }
}