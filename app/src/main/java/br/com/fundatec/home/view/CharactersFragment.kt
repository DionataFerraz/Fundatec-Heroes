package br.com.fundatec.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fundatec.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding

    private val list = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Após a criação do Adapter, nós precisamos vincular ao recyclerview utilizando a propriedade
         * adapter para setar o nosso ListItemAdapter
         * */
        val adapter = ListItemAdapter()
        binding.list.adapter = adapter
        /**
         * setItems seria a nossa função para adicionar os itens que serão exibidos na tela
         */
        adapter.setItems(list)
    }

    /**
     * LinearLayoutManager Organiza os itens em uma lista unidimensional, também podemos mudar a
     * direção da lista, ou seja podemos colocar ele na horizontal ou vertical
     * Exemplo de implementação:
     * binding.list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
     *
     * GridLayoutManager Organiza os itens em uma grid bidimensional:
     * Se a grid for organizada verticalmente, GridLayoutManager tenta fazer com que todos os elementos
     * em cada linha tenham a mesma largura e altura, mas linhas diferentes podem ter alturas diferentes.
     * Se a grid estiver organizada horizontalmente, GridLayoutManager tenta fazer com que todos os
     * elementos em cada coluna tenham a mesma largura e altura, mas colunas diferentes podem ter larguras diferentes.
     * Exemplo de implementação:
     * binding.list.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
     * O número 2 no GridLayoutManager seria a quantidade de colunas que queremos exibir na tela
     **/

    companion object {
        fun newInstance() = CharactersFragment()
    }
}