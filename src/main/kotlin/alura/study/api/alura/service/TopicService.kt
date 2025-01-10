package alura.study.api.alura.service

import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.exception.NotFoundException
import alura.study.api.alura.mapper.TopicMapper
import alura.study.api.alura.mapper.TopicViewMapper
import alura.study.api.alura.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService (
    private var topics: List<Topic> = emptyList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun fetchTopics(): List<TopicViewDTO> {
        try {
            return topics.stream().map {
                t -> topicViewMapper.map(t)
            }.collect(Collectors.toList());
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }
    }

    fun fetchTopicById(id: Long): TopicViewDTO {
        val topic = topics.find { it.id == id } ?: throw NotFoundException(notFoundMessage)
        return topicViewMapper.map(topic)
    }

    fun createTopic(topicDTO: TopicFormDTO): TopicViewDTO {
        try {
            println(topicDTO)
            topics = topics.plus(topicFormMapper.map(topicDTO))
            val topic = topics.last()
            topic.id = topics.size.toLong()-1
            return topicViewMapper.map(topic)

        } catch (e: Exception) {

            throw Exception("Error. $e")
        }
    }
//    fun updateTopic(topic: Topic) {
//        try {
//    }
}