package alura.study.api.alura.mapper

interface MapperConfig <T, U> {
    fun map(t: T): U
}