package dev.argia.userjpa.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(nullable = false)
    val username: String,
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    var createdAt: Date
) {
    @PrePersist
    fun preInsert() {
        this.createdAt = Date()
    }
}