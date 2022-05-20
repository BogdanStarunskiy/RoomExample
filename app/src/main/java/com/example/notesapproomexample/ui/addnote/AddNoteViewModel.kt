package com.example.notesapproomexample.ui.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapproomexample.REPOSITORY
import com.example.notesapproomexample.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel) {
                onSuccess
            }
        }
}