package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExplorAdapter(private val data: ArrayList<ItemPost>, val itemEvent: ItemEvent) :
    RecyclerView.Adapter<ExplorAdapter.ExplorViewHolder>() {
    lateinit var binding: ItemExploreBinding

    inner class ExplorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

            Glide.with(itemView.context).load(itemPost.imgUrl).into(binding.imgExploreMain)
            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail

            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplorViewHolder {
        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExplorViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExplorViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}