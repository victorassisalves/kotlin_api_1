package alura.study.api.alura.controller

import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.dto.TopicViewDTO
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
@RequestMapping("/topic")
class TopicForumController (private val service: TopicService) {

    @GetMapping
    fun fetchTopics(): List<TopicViewDTO> {
        return service.fetchTopics();
    }

    @GetMapping("/{id}")
    fun fetchTopicById(@PathVariable id: Long): TopicViewDTO {
        return service.fetchTopicById(id);

    }
    @PostMapping
    fun createTopic(@RequestBody @Valid topicDTO: TopicFormDTO): TopicViewDTO {
        return service.createTopic(topicDTO);
    }

    @PutMapping
    fun updateTopic() {

    }

    @DeleteMapping
    fun deleteTopic() {

    }
}