package br.com.fundatec.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.fundatec.R
import br.com.fundatec.login.HomeActivity
import br.com.fundatec.login.presentation.LoginViewModel
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.tv_text).setOnClickListener {
            showToast()
            showSnack()
        }
    }

    private fun showToast(){
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    private fun showSnack() {
        val container = findViewById<ConstraintLayout>(R.id.container)
        Snackbar
            .make(container, "Nosso Snackbar", Snackbar.LENGTH_LONG)
            .setAction("Ok") {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            .show()
    }
}