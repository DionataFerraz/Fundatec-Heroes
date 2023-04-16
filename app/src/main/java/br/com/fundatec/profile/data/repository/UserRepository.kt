package br.com.fundatec.profile.data.repository

import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.domain.model.UserModel
import br.com.fundatec.webservice.Result

interface UserRepository {
    suspend fun createUser(userModel: UserModel): Result<Unit, ErrorModel>
}