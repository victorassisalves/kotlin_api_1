package alura.study.api.alura.mapper

interface Mapper <T, U> {
    fun map(t: T): U

}
