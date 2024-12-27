package alura.study.api.alura.mapper

import alura.study.api.alura.dto.TopicAnswerFormDTO
import alura.study.api.alura.dto.TopicAnswerViewDTO
import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.model.TopicAnswer
import alura.study.api.alura.service.AuthorService
import alura.study.api.alura.service.TopicService
import org.springframework.stereotype.Component

@Component
class TopicAnswerFormMapper(
    private val authorService: AuthorService,
    private val topicService: TopicService,
): MapperConfig<TopicAnswerFormDTO, TopicAnswer> {

    override fun map(answer: TopicAnswerFormDTO): TopicAnswer {
        return TopicAnswer(
            answer = answer.answer,
            topic = topicService.fetchTopicById(answer.topic).id,
            author = authorService.fetchAuthorById(answer.author)
        )
    }
}

@Component
class TopicAnswerViewMapper: MapperConfig<TopicAnswer, TopicAnswerViewDTO> {

    override fun map(tAnswer: TopicAnswer): TopicAnswerViewDTO {
        return TopicAnswerViewDTO (
            id = tAnswer.id,
            answer = tAnswer.answer,
            topic = tAnswer.topic,
            createdAt = tAnswer.createdAt,
        )
    }
}