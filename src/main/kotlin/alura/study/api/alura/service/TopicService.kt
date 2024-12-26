package alura.study.api.alura.service

import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.mapper.TopicFormMapper
import alura.study.api.alura.mapper.TopicViewMapper
import alura.study.api.alura.model.Author
import alura.study.api.alura.model.Topic
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class TopicService (
    private var topics: List<Topic> = emptyList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
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
        try {
            val topic = topics.find { it.id == id } ?: throw Exception("Topic with ID #$id not found")
            return topicViewMapper.map(topic)
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }
    }

    fun createTopic(topicDTO: TopicFormDTO): TopicViewDTO {
        try {
            println(topicDTO)
            topics = topics.plus(topicFormMapper.map(topicDTO))
            val topic = topics.last()
            topic.id = topics.size.toLong()
            return topicViewMapper.map(topic)

        } catch (e: Exception) {

            throw Exception("Error. $e")
        }
    }
//    fun updateTopic(topic: Topic) {
//        try {
//    }
}