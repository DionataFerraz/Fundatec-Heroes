package br.com.fundatec.profile.data.repository

import br.com.fundatec.login.data.remote.LoginDataSource
import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.domain.model.UserModel
import br.com.fundatec.webservice.Result

class UserRepositoryImpl(private val loginDataSource: LoginDataSource) : UserRepository {

    override suspend fun createUser(userModel: UserModel): Result<Unit, ErrorModel> {
        return loginDataSource.createUser(userModel)
    }

}