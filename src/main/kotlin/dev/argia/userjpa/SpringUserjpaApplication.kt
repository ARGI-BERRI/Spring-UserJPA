package dev.argia.userjpa

import dev.argia.userjpa.entity.User
import dev.argia.userjpa.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringUserjpaApplication {
    @Bean
    fun init(repository: UserRepository) = CommandLineRunner {
        repository.save(User(username = "Alpine"))
        repository.save(User(username = "Berkley"))
        repository.save(User(username = "Chester"))
    }
}

fun main() {
    runApplication<SpringUserjpaApplication>()
}
