package dev.argia.userjpa.service

import dev.argia.userjpa.entity.User
import dev.argia.userjpa.exception.NotFoundException
import dev.argia.userjpa.exception.UsernameExistsException
import dev.argia.userjpa.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {
    @Autowired
    lateinit var repository: UserRepository

    override fun getUsers(): List<User> {
        return repository.findAll()
    }

    override fun getUserById(id: Int): User {
        return repository.findById(id)
            .orElseThrow { NotFoundException("$id is not exist.") }
    }

    override fun save(user: User): User {
        repository.findByUsername(user.username)
            .ifPresent { throw UsernameExistsException() }

        return repository.save(user)
    }

    override fun delete(user: User) {
        repository.delete(user)
    }

    override fun delete(id: Int) {
        repository.deleteById(id)
    }
}