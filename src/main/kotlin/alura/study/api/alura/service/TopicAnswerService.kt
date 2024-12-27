package alura.study.api.alura.service

import alura.study.api.alura.dto.TopicAnswerFormDTO
import alura.study.api.alura.dto.TopicAnswerViewDTO
import alura.study.api.alura.mapper.TopicAnswerFormMapper
import alura.study.api.alura.mapper.TopicAnswerViewMapper
import alura.study.api.alura.model.TopicAnswer
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicAnswerService (
    private var answers: List<TopicAnswer> = emptyList(),
    private val topicAnswerFormMapper: TopicAnswerFormMapper,
    private val topicAnswerViewMapper: TopicAnswerViewMapper,
){
    fun fetchAnswers(): List<TopicAnswerViewDTO> {
        try {
            return answers.stream().map {
                t -> topicAnswerViewMapper.map(t)
            }.collect(Collectors.toList());
        } catch (e: Exception) {

            throw Exception("Error. $e")
        }
    }

    fun fetchAnswerById(id: Long): TopicAnswerViewDTO {
        try {
            val answer = answers.find { it.id == id } ?: throw Exception("Answer with ID #$id not found")
            return topicAnswerViewMapper.map(answer)
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }
    }

    fun createAnswer(answerDTO: TopicAnswerFormDTO): TopicAnswerViewDTO {
        try {
            answers = answers.plus(topicAnswerFormMapper.map(answerDTO))
            val answer = answers.last()
            answer.id = answers.size.toLong()-1
            return topicAnswerViewMapper.map(answer)
        } catch (e: Exception) {
            throw Exception("Error. $e")
        }
    }
}