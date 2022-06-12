package com.example.notes.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notes.core.entity.NoteModel
import com.example.notes.core.viewModel.ViewModel
import com.example.notes.databinding.RecycleViewBinding


class Adapter (val viewModel: ViewModel, val arrayList: ArrayList<NoteModel>, val context: Context): RecyclerView.Adapter<Adapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): NotesViewHolder {
//        var root = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view, parent, false)
//        return NotesViewHolder(root)
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecycleViewBinding.inflate(inflater)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.NotesViewHolder, position: Int) {
       holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
//        if (arrayList.size == 0) {
//            Toast.makeText(context, "List is empty", Toast.LENGTH_LONG).show()
//        } else {
//
//        }
        return arrayList.size
    }


    inner class NotesViewHolder(val binding: RecycleViewBinding) : ViewHolder(binding.root) {
        fun bind(bind: NoteModel) {
            with(binding){
                txtTitle.text = bind.title
                textCreate.text = bind.des
            }
//            binding.
//            bind.title = binding
//            binding.delete.setOnClickListener {
//                viewModel.remove(blog)
//                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }
}