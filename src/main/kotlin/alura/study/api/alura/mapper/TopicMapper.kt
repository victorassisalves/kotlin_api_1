package alura.study.api.alura.mapper

import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.model.Topic
import alura.study.api.alura.service.AuthorService
import alura.study.api.alura.service.CourseService
import org.springframework.stereotype.Component

@Component
class TopicMapper(
    private val courseService: CourseService,
    private val authorService: AuthorService,
): MapperConfig<TopicFormDTO, Topic> {

    override fun map(t: TopicFormDTO): Topic {
        return Topic (
            title = t.title,
            message = t.message,
            course = courseService.fetchCourseById(t.course),
            author = authorService.fetchAuthorById(t.author),
        )
    }
}

@Component
class TopicViewMapper: MapperConfig<Topic, TopicViewDTO> {

    override fun map(t: Topic): TopicViewDTO {
        return TopicViewDTO (
            id = t.id,
            title = t.title,
            message = t.message,
            createdAt = t.createdAt,
            status = t.status
        )
    }
}