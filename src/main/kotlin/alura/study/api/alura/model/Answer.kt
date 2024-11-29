package alura.study.api.alura.model

import java.time.LocalDateTime

data class Answer (
    val id: Long? = null,
    val message: String,
    val topic: Topic,
    val author: Author,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val solution: Boolean
)
