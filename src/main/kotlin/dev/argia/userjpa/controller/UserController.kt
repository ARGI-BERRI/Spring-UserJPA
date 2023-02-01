package dev.argia.userjpa.controller

import dev.argia.userjpa.entity.User
import dev.argia.userjpa.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
    fun getUserById(@PathVariable("id") id: Int): User {
        return userService.getUserById(id)
    }

    @PostMapping("/user")
    fun createUser(@RequestBody user: User): User {
        return userService.save(user)
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable("id") id: Int) {
        // FIXME: 存在しないユーザーIDで DELETE を叩くと例外を吐く（死にはしない）
        return userService.delete(id)
    }
}