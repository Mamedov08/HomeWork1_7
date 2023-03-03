package com.example.homework1_7.domain.usecases

import com.example.homework1_7.domain.repository.NoteRepository


class GetNotesUseCase (
    private val noteRepository: NoteRepository
){
    fun getAllNotes() = noteRepository.getAllNotes()
}