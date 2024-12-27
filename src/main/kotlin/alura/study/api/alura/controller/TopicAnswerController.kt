package alura.study.api.alura.controller

import alura.study.api.alura.dto.TopicAnswerFormDTO
import alura.study.api.alura.dto.TopicAnswerViewDTO
import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.service.TopicAnswerService
import alura.study.api.alura.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic/answer")
class TopicAnswerController (private val service: TopicAnswerService) {

    @GetMapping
    fun fetchTopics(): List<TopicAnswerViewDTO> {
        return service.fetchAnswers();
    }

    @GetMapping("/{id}")
    fun fetchTopicById(@PathVariable id: Long): TopicAnswerViewDTO {
        return service.fetchAnswerById(id);

    }
    @PostMapping
    fun createTopic(@RequestBody @Valid topicAnswerDTO: TopicAnswerFormDTO): TopicAnswerViewDTO {
        return service.createAnswer(topicAnswerDTO);
    }

    @PutMapping
    fun updateTopic() {

    }

    @DeleteMapping
    fun deleteTopic() {

    }
}