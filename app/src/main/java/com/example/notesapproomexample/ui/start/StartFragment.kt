package com.example.notesapproomexample.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notesapproomexample.APP
import com.example.notesapproomexample.R
import com.example.notesapproomexample.adapter.NoteAdapter
import com.example.notesapproomexample.databinding.FragmentStartBinding
import com.example.notesapproomexample.model.NoteModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.initDatabase()
        val recyclerView = binding.rvNotes
        val adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setList(listNotes.asReversed())
        }
        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    companion object {
        fun clickNote(noteModel: NoteModel) {
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }
    }
}