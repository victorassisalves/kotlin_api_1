package alura.study.api.alura.dto

data class TopicFormDTO (
    val title: String,
    val message: String,
    val course: Long,
    val author: Long
)