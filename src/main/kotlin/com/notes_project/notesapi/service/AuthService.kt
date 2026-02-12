package com.notes_project.notesapi.service

import com.notes_project.notesapi.config.JwtUtil
import com.notes_project.notesapi.model.User
import com.notes_project.notesapi.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {

    fun register(username: String, password: String): String {
        val encodedPassword = passwordEncoder.encode(password)
        userRepository.save(User(username = username, password = encodedPassword))
        return "User registered successfully"
    }

    fun login(username: String, password: String): String {
        val user = userRepository.findByUsername(username)
            ?: throw RuntimeException("User not found")

        if (!passwordEncoder.matches(password, user.password)) {
            throw RuntimeException("Invalid password")
        }

        return jwtUtil.generateToken(username)
    }
}
