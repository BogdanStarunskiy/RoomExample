package com.example.notesapproomexample.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notesapproomexample.APP
import com.example.notesapproomexample.R
import com.example.notesapproomexample.databinding.FragmentDetailBinding
import com.example.notesapproomexample.model.NoteModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescriptionDetail.text = currentNote.description
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNote)
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }
}