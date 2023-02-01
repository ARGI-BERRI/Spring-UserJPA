package dev.argia.userjpa.service

import dev.argia.userjpa.entity.User
import org.springframework.stereotype.Service
import java.util.*

@Service
interface UserService {
    fun getUsers(): List<User>
    fun getUserById(id: Int?): Optional<User>
    fun save(user: User): User
    fun delete(id: Int)
}