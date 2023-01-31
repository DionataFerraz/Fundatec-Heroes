package br.com.fundatec.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.databinding.ListItemBinding

class ListItemAdapter : RecyclerView.Adapter<ListItemViewHolder>() {

    private val list = mutableListOf<String>()

    /**
     * onCreateViewHolder(): RecyclerView chama esse método sempre que precisa criar um novo ViewHolder.
     * O método cria e inicializa o ViewHolder e a View associada, mas não preenche o conteúdo da visualização.
     * O ViewHolder ainda não foi vinculado a dados específicos.
     * Ou seja nesse caso poderiamos ter mais de um layout para os itens da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    /**
     * getItemCount(): a RecyclerView chama esse método para ver o tamanho do conjunto de dados.
     * Por exemplo, em um app de lista de endereços, pode ser o número total de endereços.
     * O RecyclerView usa essa função para determinar quando não há mais itens a serem exibidos.
     */
    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * onBindViewHolder(): RecyclerView chama esse método para associar um ViewHolder aos dados.
     * O método busca os dados apropriados e usa esses dados para preencher o layout do fixador de
     * visualização. Por exemplo, se a RecyclerView exibir uma lista de nomes, o método poderá encontrar
     * o nome apropriado na lista e preencher o widget TextView do fixador de visualização.
     */
    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<String>) {
        list.addAll(items)
    }
}