package com.notes_project.notesapi.repository


import com.notes_project.notesapi.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findByUsername(username: String): User?
}
