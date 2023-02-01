package dev.argia.userjpa.service

import dev.argia.userjpa.entity.User
import dev.argia.userjpa.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl: UserService {
    @Autowired
    lateinit var repository: UserRepository

    override fun getUsers(): List<User> {
        return repository.findAll()
    }

    override fun getUserById(id: Int?): Optional<User> {
        return id?.let { repository.findById(it) } ?: Optional.empty()
    }

    override fun save(user: User): User {
        return repository.save(user)
    }

    override fun delete(id: Int) {
        repository.deleteById(id)
    }
}