package com.example.notesapproomexample.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapproomexample.REPOSITORY
import com.example.notesapproomexample.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    fun delete(noteModel: NoteModel) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel) {}
        }
}