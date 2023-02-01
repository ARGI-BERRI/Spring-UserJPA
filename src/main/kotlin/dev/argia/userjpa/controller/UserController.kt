package dev.argia.userjpa.controller

import dev.argia.userjpa.entity.User
import dev.argia.userjpa.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping("/users")
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable("id") id: Int?): Optional<User> {
        return userService.getUserById(id)
    }

    @PostMapping("/user")
    fun createUser(@RequestBody user: User): User {
        return userService.save(user)
    }
}