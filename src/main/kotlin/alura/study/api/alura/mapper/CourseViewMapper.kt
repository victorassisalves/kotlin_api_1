package alura.study.api.alura.mapper

import alura.study.api.alura.dto.CourseViewDTO
import alura.study.api.alura.model.Course
import org.springframework.stereotype.Component

@Component
class CourseViewMapper: Mapper<Course, CourseViewDTO> {
    override fun map(t: Course): CourseViewDTO {
        return CourseViewDTO(
            t.id,
            t.name,
            t.category
        )
    }
}