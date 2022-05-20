package com.example.notesapproomexample.ui.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notesapproomexample.REPOSITORY
import com.example.notesapproomexample.database.NoteDatabase
import com.example.notesapproomexample.database.repository.NoteRealisation
import com.example.notesapproomexample.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }


}