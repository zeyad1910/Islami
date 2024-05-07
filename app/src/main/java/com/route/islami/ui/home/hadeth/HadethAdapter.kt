package com.route.islami.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.HadethItemBinding

class HadethAdapter(private val hadethList:List<Hadeth>) : RecyclerView.Adapter<HadethAdapter.ViewHolder>() {
    var onHadethClickListener : OnHadethClickListener? = null
    class ViewHolder(val itemBinding: HadethItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = HadethItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.itemBinding.tvHadethName.text = hadeth.title
        holder.itemView.setOnClickListener {
            onHadethClickListener?.onHadethClick(hadeth,position)
        }
    }

    fun interface OnHadethClickListener{
        fun onHadethClick(hadeth: Hadeth, position:Int)
    }
}