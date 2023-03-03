package com.example.homework1_7.domain.repository

import com.example.homework1_7.Resourse.Resource
import com.example.homework1_7.domain.model.Note
import java.util.concurrent.Flow

interface NoteRepository {

    fun createNote(note: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun editNote(note: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun deleteNote(note: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun getAllNotes(): kotlinx.coroutines.flow.Flow <List<Note>>
}