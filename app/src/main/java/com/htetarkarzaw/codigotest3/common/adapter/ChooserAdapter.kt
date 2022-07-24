package com.htetarkarzaw.codigotest3.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.htetarkarzaw.codigotest3.databinding.ViewHolderChooserBinding

class ChooserAdapter(
    private val onClickItem: (Int) -> Unit
) :
    ListAdapter<String, RecyclerView.ViewHolder>(newDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ViewHolderChooserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LanguageViewHolder).bind(getItem(position))
    }

    companion object {
        val newDiffUtil = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun getClickItem(position: Int): String = getItem(position)

    inner class LanguageViewHolder(private val binding: ViewHolderChooserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String?) {
            binding.tvName.text = item ?: ""
            itemView.setOnClickListener { onClickItem(adapterPosition) }
        }
    }
}