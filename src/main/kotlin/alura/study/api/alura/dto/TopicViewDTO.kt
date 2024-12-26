package alura.study.api.alura.dto

import alura.study.api.alura.model.TopicStatus
import java.time.LocalDateTime

data class TopicViewDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
