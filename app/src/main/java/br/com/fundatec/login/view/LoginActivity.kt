package br.com.fundatec.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.character.view.Character
import br.com.fundatec.databinding.ActivityLoginBinding
import br.com.fundatec.home.view.HomeActivity
import br.com.fundatec.login.presentation.LoginViewModel
import br.com.fundatec.login.presentation.ViewState
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class LoginActivity : AppCompatActivity() {

    /**
     * Essa variavel é responsavel por criar o nosso adater moshi, esse adapter é responsável por
     * transformar uma classe kotlin em json/string ou json/string em uma classe kotlin, quando olhamos o .add
     * do Builder podemos ver que estamos adicionando uma outra factory(KotlinJsonAdapterFactory), essa factory
     * é responsavel por criar os conversores de kotlin mensionados acima, caso estivessemos
     * utilizando java não precisariamos desse KotlinJsonAdapterFactory
     *
     * Pq estamos utilizando o by lazy? A ideia do lazy é permitir a inicialização de property na
     * primeira vez que for utilizada, e então, nas próximas vezes de uso, o valor atribuído é
     * devolvido imediatamente, como se fosse um cache
     **/
    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    /**
     * Objeto de exemplo para que seja salvo no shared preferences
     */
    private val character by lazy {
        Character("Batman", 40)
    }

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Para que possamos utilizar o cache SharedPreferences, nós precisamos estar dentro de um
         * fragment/activity ou acessar de algum android context para ter acesso as funções dele,
         * quando acessamos o getSharedPreferences, precisamo criar uma chave que será necessária
         * para ler/escrever os valores que gostariamos de salvar na aplicação, no nosso caso chamamos de bd
         *
         * Um pouco sobre o MODE_PRIVATE
         * MODE_PRIVATE: Modo de criação de arquivo: o modo padrão, onde o arquivo criado só
         * pode ser acessado pelo aplicativo chamador (ou todos os aplicativos que compartilham o
         * mesmo ID de usuário).
         *
         * MODE_WORLD_READABLE: Modo de criação de arquivo: permite que todos os outros aplicativos
         * tenham acesso de leitura ao arquivo criado.
         *
         * MODE_WORLD_WRITEABLE : Modo de criação de arquivo: permite que todos os outros
         * aplicativos tenham acesso de gravação ao arquivo criado.
         */
        val preferences = getSharedPreferences("bd", MODE_PRIVATE)
        /** Par transformar a nossa classe kotlin e json/string, nós precisamos acessar uma função
         * do builder criado na linha 28, essa função precisa receber qual o tipo de Objeto no
         * nosso caso é o Character, logo após precisamos acessar a função que transformara o nosso
         * objeto kotlin em em json(toJson) passando por parametro o nosso exemplo de objeto, caso
         * tenhamos que fazer o contrário, transformar a string em um objeto podemos utilizar o fromJson
         */
        val characterString = moshi.adapter(Character::class.java).toJson(character)

        /** Para que possamos salvar ou editar o valores dentro do sharedpreferences, nós precisamos
         * utilizar a função edit(), ao acessa ele nos retornar uma interface do tipo Editor que
         * contem alguns tipos primitivos que podemos salvar, no nosso caso salvaremos uma string,
         * pois o nosso adapter transformou o nosso objeto em json/string, para salvar utilizamos a
         * função putString que necessita de uma chave, essa chave será necessária para resgatar o
         * valor futuramente e o segundo valor que passamo na função é o valor que será salvo,
         * para realizar de fato a transação nós precisamo chamar a função commit() dessa forma será
         * salvo o valor no SharedPreferences
         */
        preferences.edit().putString("character", characterString).commit()

        binding.etEmail.error = "Campo obrigatório"

        configLoginButton()
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowHome -> showSnack()
            }
        }
    }

    private fun configLoginButton() {
        binding.btLogin.setOnClickListener {
//            viewModel.validateUserInput(
//                email = binding.etEmail.text.toString(),
//                password = binding.etPassword.text.toString(),
//            )
            showSnack()
        }
    }

    private fun showSnack() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}