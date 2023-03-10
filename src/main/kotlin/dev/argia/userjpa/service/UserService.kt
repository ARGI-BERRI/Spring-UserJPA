package dev.argia.userjpa.service

import dev.argia.userjpa.entity.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getUsers(): List<User>
    fun getUserById(id: Int): User
    fun save(user: User): User
    fun delete(user: User)
    fun delete(id: Int)
}