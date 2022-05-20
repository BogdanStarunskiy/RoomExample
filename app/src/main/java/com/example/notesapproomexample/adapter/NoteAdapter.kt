package com.example.notesapproomexample.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapproomexample.R
import com.example.notesapproomexample.model.NoteModel
import com.example.notesapproomexample.ui.start.StartFragment
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var listNote = emptyList<NoteModel>()

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = listNote[position].title
    }

    override fun getItemCount(): Int {
      return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}