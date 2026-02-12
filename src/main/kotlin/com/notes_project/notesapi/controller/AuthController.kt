package com.notes_project.notesapi.controller

import com.notes_project.notesapi.model.AuthRequest
import com.notes_project.notesapi.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: AuthRequest): String {
        return authService.register(request.username, request.password)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): String {
        return authService.login(request.username, request.password)
    }
}
