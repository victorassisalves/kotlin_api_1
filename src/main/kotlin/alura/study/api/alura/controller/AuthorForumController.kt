package alura.study.api.alura.controller

import alura.study.api.alura.model.Author
import alura.study.api.alura.service.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorForumController (private val service: AuthorService) {

    @GetMapping
    fun fetchAuthors(): List<Author> {
        return service.fetchAuthors();
    }

    @GetMapping("/{id}")
    fun fetchAuthorById(@PathVariable id: Long): Author {
        return service.fetchAuthorById(id);

    }
    @PostMapping
    fun createAuthor(@RequestBody  author: Author): Author {
        return service.createAuthor(author);
    }

    @PutMapping
    fun updateAuthor() {

    }
//
//    @DeleteMapping
//    fun deleteAuthor() {
//
//    }

}