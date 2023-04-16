package br.com.fundatec.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import br.com.fundatec.R
import br.com.fundatec.databinding.ActivityProfileBinding
import br.com.fundatec.profile.presentation.ProfileViewModel
import br.com.fundatec.profile.presentation.viewstate.ProfileViewState
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeButton()
        observerState()
    }

    private fun initializeButton() {
        binding.btCreate.setOnClickListener {
            viewModel.saveUser(
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString(),
            )
        }
    }

    private fun observerState() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                is ProfileViewState.OnSuccess -> onSuccess()
                is ProfileViewState.Loading -> onLoading()
                is ProfileViewState.ShowErrorRequestMessage -> showErrorMessage()
            }
        }
    }

    private fun onSuccess() {
        binding.pbLoading.isVisible = false
        Snackbar.make(binding.container, R.string.success_message, Snackbar.LENGTH_LONG).show()
        finish()
    }

    private fun onLoading() {
        binding.pbLoading.isVisible = true
    }

    private fun showErrorMessage() {
        binding.pbLoading.isVisible = false
        Snackbar.make(binding.container, R.string.error_login, Snackbar.LENGTH_LONG).show()
    }
}
