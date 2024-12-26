package alura.study.api.alura.mapper

import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicViewDTO> {

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