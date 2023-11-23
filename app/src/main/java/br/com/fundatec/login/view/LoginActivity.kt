package br.com.fundatec.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import br.com.fundatec.R
import br.com.fundatec.databinding.ActivityLoginBinding
import br.com.fundatec.home.view.HomeActivity
import br.com.fundatec.login.presentation.LoginViewModel
import br.com.fundatec.login.presentation.ViewState
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configLoginButton()
        configObservers()
    }

    private fun configObservers() {
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowHome -> showHome()
                is ViewState.ShowErrorEmptyFileds -> showSnackBarError(R.string.error_empty_fields)
                is ViewState.ShowLoading -> showLoading()
                is ViewState.ShowErrorApiLogin -> showSnackBarError(R.string.error_login)
            }
        }
    }

    private fun configLoginButton() {
        binding.btLogin.setOnClickListener {
            viewModel.validateUserInput(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString(),
            )
        }
    }

    private fun showHome() {
        hideLoging()
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun showSnackBarError(@StringRes messageId: Int) {
        hideLoging()
        Snackbar.make(binding.container, messageId, Snackbar.LENGTH_LONG).show()
    }

    private fun showLoading() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    private fun hideLoging() {
        binding.pbLoading.visibility = View.GONE
    }
}