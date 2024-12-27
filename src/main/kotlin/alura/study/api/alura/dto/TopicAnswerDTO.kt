package alura.study.api.alura.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class TopicAnswerFormDTO (
    @field:NotEmpty @field:Size(min = 15)
    val answer: String,
    @field:NotNull
    val topic: Long,
    @field:NotNull
    val author: Long
)

data class TopicAnswerViewDTO(
    val id: Long?,
    val answer: String,
    val topic: Long?,
    val createdAt: LocalDateTime
)