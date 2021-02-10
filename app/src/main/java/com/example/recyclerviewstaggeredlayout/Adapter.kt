package com.example.recyclerviewstaggeredlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewstaggeredlayout.databinding.RecyclerViewItemBinding

class Adapter(private val context: Context, private val list: List<RecyclerViewItem>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val binding = DataBindingUtil.inflate<RecyclerViewItemBinding>(
            LayoutInflater.from(context),
            R.layout.recycler_view_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(obj: RecyclerViewItem) {
            Glide.with(context)
                .load(obj.image)
                .into(binding.image)
        }
    }
}