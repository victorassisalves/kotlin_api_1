package alura.study.api.alura.dto

data class CourseViewDTO(
    var id: Long?,
    val name: String,
    val category: String
)

data class CourseFormDTO(
    val name: String,
    val category: String
)
