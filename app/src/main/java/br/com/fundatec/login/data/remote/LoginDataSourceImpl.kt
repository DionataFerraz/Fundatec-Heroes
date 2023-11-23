package br.com.fundatec.login.data.remote

import android.util.Log
import br.com.fundatec.login.data.response.LoginResponse
import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.webservice.RetrofitNetworkClient
import br.com.fundatec.webservice.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginDataSourceImpl : LoginDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(LoginApi::class.java)

    override suspend fun login(email: String, password: String): Result<LoginResponse, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val loginResponse = service.login(email = email, password = password)
                Result.Success(loginResponse)
            } catch (exception: Exception) {
                Log.e("LoginDataSource", exception.message ?: "")
                Result.Error(ErrorModel.ErrorLogin)
            }
        }

    }

}
