package com.route.islami.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.QuranItemBinding

class SuraAdapter(val list: List<Sura>) : RecyclerView.Adapter<SuraAdapter.ViewHolder>() {
    var onSuraClickListener : OnSuraClickListener? = null
    class ViewHolder(val itemBinding:QuranItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = QuranItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sura = list[position]
        holder.itemBinding.tvChapterName.text = sura.suraName[position]
        holder.itemBinding.tvVerseNum.text= sura.ayatNum[position]
        holder.itemView.setOnClickListener {
            onSuraClickListener?.let {
                it.onSuraClick(sura.suraName[position],position)
            }
        }
    }
    fun interface OnSuraClickListener{
        fun onSuraClick(suraName:String,position: Int)
    }
}