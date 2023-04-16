package br.com.fundatec.profile.domain.usecase

import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.data.repository.UserRepository
import br.com.fundatec.profile.domain.model.UserModel
import br.com.fundatec.webservice.Result

class UserUseCaseImpl(private val repository: UserRepository) : UserUseCase {

    override suspend fun createUser(userModel: UserModel): Result<Unit, ErrorModel> {
        return repository.createUser(userModel)
    }

}