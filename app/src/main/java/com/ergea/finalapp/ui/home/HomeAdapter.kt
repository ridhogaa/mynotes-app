package com.ergea.finalapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.databinding.ItemListHomeBinding.inflate
import com.ergea.finalapp.databinding.ItemListHomeBinding
import com.ergea.finalapp.ui.update.UpdateDialogFragment

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

class HomeAdapter(
    private val listNote: List<NoteEntity>,
    private val itemClicked: ItemClickListener
) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: ItemListHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteEntity) {
            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description
            binding.ivEdit.setOnClickListener {
                itemClicked.editClicked(note)
            }
            binding.ivDelete.setOnClickListener {
                itemClicked.deleteClicked(note)
            }
        }
    }

    interface ItemClickListener {
        fun editClicked(noteEntity: NoteEntity)
        fun deleteClicked(noteEntity: NoteEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = listNote.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listNote[position])
    }
}