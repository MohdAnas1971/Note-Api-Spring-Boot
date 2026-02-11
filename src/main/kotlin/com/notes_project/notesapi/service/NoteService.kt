package com.notes_project.notesapi.service


import com.notes_project.notesapi.model.Note
import com.notes_project.notesapi.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {

    fun createNote(note: Note): Note {
        return noteRepository.save(note)
    }

    fun getAllNotes(): List<Note> {
        return noteRepository.findAll()
    }

    fun getNoteById(id: String): Note? {
        return noteRepository.findById(id).orElse(null)
    }

    fun updateNote(id: String, updatedNote: Note): Note? {
        val existing = noteRepository.findById(id)

        return if (existing.isPresent) {
            val note = existing.get()
            val newNote = note.copy(
                title = updatedNote.title,
                content = updatedNote.content
            )
            noteRepository.save(newNote)
        } else {
            null
        }
    }

    fun deleteNote(id: String): Boolean {
        return if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
