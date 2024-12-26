package alura.study.api.alura.controller

import alura.study.api.alura.model.Author
import alura.study.api.alura.model.Course
import alura.study.api.alura.service.AuthorService
import alura.study.api.alura.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/course")
class CourseForumController (private val service: CourseService) {

    @GetMapping
    fun fetchAuthors(): List<Course> {
        return service.fetchCourses();
    }

    @GetMapping("/{id}")
    fun fetchAuthorById(@PathVariable id: Long): Course {
        return service.fetchCourseById(id);

    }
    @PostMapping
    fun createAuthor(@RequestBody  course: Course): Course {
        return service.createCourse(course);
    }

//    @PutMapping
//    fun updateAuthor() {
//
//    }
//
//    @DeleteMapping
//    fun deleteAuthor() {
//
//    }

}