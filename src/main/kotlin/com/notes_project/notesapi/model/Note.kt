package com.notes_project.notesapi.model


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Document(collection = "notes")
data class Note(

    @Id
    val id: String? = null,

    @field:NotBlank(message = "Title is required")
    val title: String,

    @field:NotBlank(message = "Content is required")
    val content: String,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
