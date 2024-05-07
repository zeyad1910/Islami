package com.route.islami.ui.home.suraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.VerseItemBinding

class VerseAdapter(private val verseList: List<String>) : RecyclerView.Adapter<VerseAdapter.ViewHolder>() {
    class ViewHolder(val itemBinding: VerseItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = VerseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = verseList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val verse = verseList[position]
        holder.itemBinding.tvVerse.text = verse
    }
}