package alura.study.api.alura.controller

import alura.study.api.alura.dto.TopicDTO
import alura.study.api.alura.model.Topic
import alura.study.api.alura.service.TopicService
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
    fun fetchTopics(): List<Topic> {
        return service.fetchTopics();
    }

    @GetMapping("/{id}")
    fun fetchTopicById(@PathVariable id: Long): Topic {
        return service.fetchTopicById(id);

    }
    @PostMapping
    fun createTopic(@RequestBody  topicDTO: TopicDTO): Topic {
        return service.createTopic(topicDTO);
    }

    @PutMapping
    fun updateTopic() {

    }

    @DeleteMapping
    fun deleteTopic() {

    }
}