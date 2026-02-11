package com.notes_project.notesapi.controller

import com.notes_project.notesapi.model.Note
import com.notes_project.notesapi.service.NoteService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController(private val noteService: NoteService) {

    @PostMapping
    fun createNote(@Valid @RequestBody note: Note): ResponseEntity<Note> {
        return ResponseEntity.ok(noteService.createNote(note))
    }

    @GetMapping
    fun getAllNotes(): ResponseEntity<List<Note>> {
        return ResponseEntity.ok(noteService.getAllNotes())
    }

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: String): ResponseEntity<Note> {
        val note = noteService.getNoteById(id)
        return note?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun updateNote(
        @PathVariable id: String,
        @Valid @RequestBody updatedNote: Note
    ): ResponseEntity<Note> {

        val note = noteService.updateNote(id, updatedNote)
        return note?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: String): ResponseEntity<String> {
        val deleted = noteService.deleteNote(id)

        return if (deleted)
            ResponseEntity.ok("Note deleted successfully")
        else
            ResponseEntity.notFound().build()
    }
}
