package br.com.fundatec.login.data.remote

import android.util.Log
import br.com.fundatec.login.data.response.LoginResponse
import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.data.remote.UserRequest
import br.com.fundatec.profile.domain.model.UserModel
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

    override suspend fun createUser(userModel: UserModel): Result<Unit, ErrorModel> {
        return withContext(Dispatchers.IO) {
            val userRequest = UserRequest(
                name = userModel.name,
                email = userModel.email,
                password = userModel.password,
            )
            try {
                val response = service.createUser(userRequest = userRequest)
                if (response.isSuccessful) {
                    Result.Success(Unit)
                } else {
                    Log.e("Login DataSource", response.message())
                    Result.Error(ErrorModel.ErrorLogin)
                }
            } catch (exception: Exception) {
                Log.e("Login DataSource", exception.message ?: "")
                Result.Error(ErrorModel.ErrorLogin)
            }
        }
    }

}
