package br.com.fundatec.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import br.com.fundatec.R
import br.com.fundatec.login.presentation.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvText = findViewById<TextView>(R.id.tv_text).apply {
            setOnClickListener {
                viewModel.changeText("Novo texto")
            }
        }

        viewModel.newText.observe(this) { newText ->
            tvText.text = newText
        }
    }
}