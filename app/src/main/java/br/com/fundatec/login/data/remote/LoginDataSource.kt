package br.com.fundatec.login.data.remote

import br.com.fundatec.login.data.response.LoginResponse
import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.webservice.Result

interface LoginDataSource {
    suspend fun login(email: String, password: String): Result<LoginResponse, ErrorModel>
}