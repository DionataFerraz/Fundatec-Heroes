package br.com.fundatec.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.databinding.ListItemBinding

class ListItemAdapter : RecyclerView.Adapter<ListItemViewHolder>() {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<String>) {
        list.addAll(items)
    }
}