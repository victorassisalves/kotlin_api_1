package alura.study.api.alura.dto

import java.time.LocalDateTime

data class ErrorViewDTO(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val error: String,
    val message: String?,
    val status: Int,
    val path: String
)
