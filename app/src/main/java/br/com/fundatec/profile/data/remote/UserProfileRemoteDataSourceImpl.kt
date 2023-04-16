package br.com.fundatec.profile.data.remote

import android.util.Log
import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.domain.model.UserModel
import br.com.fundatec.webservice.Result
import br.com.fundatec.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserProfileRemoteDataSourceImpl : UserProfileRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(UserProfileApi::class.java)

    override suspend fun createUser(userModel: UserModel) {
        withContext(Dispatchers.IO) {
            try {
                service.createUser(
                    userRequest = UserRequest(
                        name = userModel.name,
                        email = userModel.email,
                        password = userModel.password,
                    )
                )
                Result.Success(Unit)
            } catch (exception: Exception) {
                Log.e("LoginDataSource", exception.message ?: "")
                Result.Error(ErrorModel.ErrorLogin)
            }
        }

    }
}