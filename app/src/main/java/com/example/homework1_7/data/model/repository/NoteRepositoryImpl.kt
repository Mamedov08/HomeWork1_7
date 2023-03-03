package com.example.homework1_7.data.model.repository

import com.example.homework1_7.Resourse.Resource
import com.example.homework1_7.data.local.NoteDao
import com.example.homework1_7.data.mappers.toNote
import com.example.homework1_7.data.mappers.toNoteEntity
import com.example.homework1_7.domain.model.Note
import com.example.homework1_7.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository{

    override fun createNote(note: Note) : Flow<Resource<Unit>> = flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.createNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (IOException) {
            emit(Resource.Error(ioException.locallizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.createNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (IOException) {
            emit(Resource.Error(ioException.locallizedMessage ?: "Unknown error"))
        }

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.createNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (IOException) {
            emit(Resource.Error(ioException.locallizedMessage ?: "Unknown error"))
        }
    override fun getNotes(): Flow<Resource<List<Note>>> = flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.createNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (IOException) {
            emit(Resource.Error(ioException.locallizedMessage ?: "Unknown error"))
        }
    }
