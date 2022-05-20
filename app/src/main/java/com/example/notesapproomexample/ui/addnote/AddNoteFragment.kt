package com.example.notesapproomexample.ui.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notesapproomexample.APP
import com.example.notesapproomexample.R
import com.example.notesapproomexample.databinding.FragmentAddNoteBinding
import com.example.notesapproomexample.model.NoteModel

class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.btnAdd.setOnClickListener {
            val title = binding.edTitle.text.toString()
            val description = binding.edDescription.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)) {}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }
}