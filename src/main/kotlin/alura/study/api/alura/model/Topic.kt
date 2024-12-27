package alura.study.api.alura.model

import alura.study.api.alura.dto.CourseViewDTO
import java.time.LocalDateTime

data class Topic (
    var id: Long? = null,
    val title: String,
    val message: String,
    val course: CourseViewDTO,
    val author : Author,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val response: List<Answer> = ArrayList()
)