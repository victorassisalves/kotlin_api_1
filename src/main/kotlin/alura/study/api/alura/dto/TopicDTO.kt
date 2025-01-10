package alura.study.api.alura.dto

import jakarta.validation.constraints.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import alura.study.api.alura.model.TopicStatus
import jakarta.validation.constraints.Positive
import java.time.LocalDateTime

data class TopicFormDTO (
    @field:NotEmpty(message = "Title cannot be empty")
    @field:Size(min = 5, message = "Title must have more than 5 characters")
    val title: String,
    @field:NotEmpty(message = "Message cannot be empty")
    @field:Size(min = 5, message = "Title must have more than 5 characters")
    val message: String,
    @field:NotNull(message = "Course cannot be null")
    @field:Positive(message = "Course must be a positive number")
    val course: Long,
    @field:NotNull(message = "Author cannot be null")
    @field:Positive(message = "Author must be a positive number")
    val author: Long
)

data class TopicViewDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
