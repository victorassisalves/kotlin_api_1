package alura.study.api.alura.service

import alura.study.api.alura.dto.TopicDTO
import alura.study.api.alura.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService (
    private var topics: List<Topic> = emptyList(),
    private val courseService: CourseService,
    private val authorService: AuthorService
) {
    fun fetchTopics(): List<Topic> {
        try {
            return topics;
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }

    }

    fun fetchTopicById(id: Long): Topic {
        try {
            return topics.find { it.id == id } ?: throw Exception("Topic with ID #$id not found")
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }
    }

    fun createTopic(topicDTO: TopicDTO): Topic {
        try {
            topics = topics.plus(
                Topic(
                    id = topics.size.toLong(),
                    title = topicDTO.title,
                    message = topicDTO.message,
                    course = courseService.fetchCourseById(topicDTO.course),
                    author = authorService.fetchAuthorById(topicDTO.author)
                )
            )
            return topics.last()
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }
    }
//    fun updateTopic(topic: Topic) {
//        try {
//    }
}