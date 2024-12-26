package alura.study.api.alura.mapper

import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.model.Topic
import alura.study.api.alura.service.AuthorService
import alura.study.api.alura.service.CourseService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val authorService: AuthorService,
): Mapper<TopicFormDTO, Topic> {

    override fun map(t: TopicFormDTO): Topic {
        return Topic (
            title = t.title,
            message = t.message,
            course = courseService.fetchCourseById(t.course),
            author = authorService.fetchAuthorById(t.author),
        )
    }
}