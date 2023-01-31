package br.com.fundatec.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.databinding.ListItemBinding

/**
 * Cada elemento individual na lista é definido por um objeto viewholder. Quando o viewholder é
 * criado, ele não possui nenhum dado associado a ele. Depois que o view holder da exibição é criado,
 * o RecyclerView o vincula aos seus dados. Você define o view holder da exibição estendendo RecyclerView.ViewHolder.
 *
 *
 * Classe responsavel por fazer o binding da nosso item com os dados que iremos apresentar, ou seja
 * nessa classe será responsavel por setar a descrição, nome, imagem... no xml desde que tenhamos
 * criado o layout no xml
 *
 *
 **/
class ListItemViewHolder(
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.tvName.text = name
    }
}