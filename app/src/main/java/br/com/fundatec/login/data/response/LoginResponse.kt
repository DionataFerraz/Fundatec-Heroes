package br.com.fundatec.login.data.response

data class LoginResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)