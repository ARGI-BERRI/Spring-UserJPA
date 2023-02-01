package dev.argia.userjpa.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    var createdAt: Date? = null,

    @Column(nullable = false)
    var username: String,
) {
    @PrePersist
    fun preInsert() {
        this.createdAt = Date()
    }
}