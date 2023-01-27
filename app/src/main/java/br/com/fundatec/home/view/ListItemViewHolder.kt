package br.com.fundatec.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.databinding.ListItemBinding

class ListItemViewHolder(
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.tvName.text = name
    }
}