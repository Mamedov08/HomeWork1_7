package com.example.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework1_7.data.local.NoteDao
import com.example.homework1_7.data.model.repository.NoteRepositoryImpl
import com.example.homework1_7.domain.model.Note
import com.example.homework1_7.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "note_db"
    ).allonMainThreadQueries().build()
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()


    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDao: NoteDao
    ): NoteRepository = NoteRepositoryImpl(noteDao)

}