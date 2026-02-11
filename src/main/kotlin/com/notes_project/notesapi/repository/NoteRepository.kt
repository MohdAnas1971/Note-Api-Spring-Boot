package com.notes_project.notesapi.repository

import com.notes_project.notesapi.model.Note
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository : MongoRepository<Note, String>
