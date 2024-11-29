package alura.study.api.alura.model

import java.time.LocalDateTime

data class Topic (
    val id: Long? = null,
    val title: String,
    val message: String,
    val course: Course,
    val author : Author,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val response: List<Answer> = ArrayList()
)