package alura.study.api.alura.controller

import alura.study.api.alura.dto.TopicFormDTO
import alura.study.api.alura.dto.TopicViewDTO
import alura.study.api.alura.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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
    fun createTopic(
        @RequestBody @Valid topicDTO: TopicFormDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicViewDTO> {
        val topic = service.createTopic(topicDTO);
        val uri = uriBuilder.path("/topic/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic);
    }

    @PutMapping
    fun updateTopic() {

    }

    @DeleteMapping
    fun deleteTopic() {

    }
}