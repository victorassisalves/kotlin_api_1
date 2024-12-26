package alura.study.api.alura.service

import alura.study.api.alura.model.Author
import org.springframework.stereotype.Service

@Service
class AuthorService (private var authors: List<Author> = emptyList() ) {
    init {
        val author1 = Author(
            id = 0,
            name = "Robert C. Martin",
            email = "robert@email.com"
        )

        val author2 = Author(
            id = 1,
            name = "Martin Fowler",
            email = "martin@email.com"
        )

        val author3 = Author(
            id = 2,
            name = "Fowler K. Beck",
            email = "kent@email.com"
        )
        authors = listOf(author1, author2, author3)
    }

    fun fetchAuthors(): List<Author> {
        return authors
    }

    fun fetchAuthorById(id: Long): Author {
        return authors.first { it.id == id }  ?: throw Exception("Author with ID #$id not found")
    }

    fun createAuthor(author: Author): Author {
        authors = authors.plus(Author(
            id = authors.size.toLong(),
            name = author.name,
            email = author.email
        ))

        return authors.last()
    }
//
//    fun updateAuthor(author: Author) {
//        authors = authors.map { if (it.id == author.id) author else it }
//    }
//
//    fun deleteAuthor(id: Long) {
//        // Remove author from list
//        authors = authors.filter { it.id != id }
//    }
}