package dev.argia.userjpa

import dev.argia.userjpa.entity.User
import dev.argia.userjpa.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class SpringUserjpaApplication {
    @Bean
    fun init(repository: UserRepository) = CommandLineRunner {
        repository.save(User(1, "Alpine", Date()))
        repository.save(User(2, "Berkley", Date()))
        repository.save(User(3, "Chester", Date()))
    }
}

fun main() {
    runApplication<SpringUserjpaApplication>()
}
