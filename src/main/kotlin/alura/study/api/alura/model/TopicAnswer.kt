package alura.study.api.alura.model

import java.time.LocalDateTime

data class TopicAnswer(
    var id: Long? = null,
    val answer: String,
    val topic: Long?,
    val author: Author,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
