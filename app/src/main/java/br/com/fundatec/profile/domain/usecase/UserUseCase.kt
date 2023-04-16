package br.com.fundatec.profile.domain.usecase

import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.domain.model.UserModel
import br.com.fundatec.webservice.Result

interface UserUseCase {
    suspend fun createUser(userModel: UserModel): Result<Unit, ErrorModel>
}