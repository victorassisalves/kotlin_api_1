package alura.study.api.alura.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import alura.study.api.alura.model.TopicStatus
import java.time.LocalDateTime

data class TopicFormDTO (
    @field:NotEmpty @field:Size(min = 5)
    val title: String,
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val course: Long,
    @field:NotNull
    val author: Long
)

data class TopicViewDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
