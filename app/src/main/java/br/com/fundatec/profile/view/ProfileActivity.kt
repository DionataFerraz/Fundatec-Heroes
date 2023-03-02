package br.com.fundatec.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.databinding.ActivityProfileBinding
import br.com.fundatec.profile.presentation.ProfileViewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.saveUser()
    }
}

// coisas que haviam faltado
// estava faltando adicionar o App no manifest
// estava faltando deixar as funções async, para rodar na main thread nós precisamos habilitar essa config no
// FHDatabase allowMainThreadQueries()