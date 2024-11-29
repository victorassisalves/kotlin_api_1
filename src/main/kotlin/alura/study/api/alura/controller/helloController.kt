package alura.study.api.alura.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")

class HelloController {
    @RequestMapping
    fun hello(): String {
        return "Hello my, Alura!"
    }
}