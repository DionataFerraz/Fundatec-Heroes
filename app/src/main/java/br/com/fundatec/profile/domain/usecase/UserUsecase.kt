package br.com.fundatec.profile.domain.usecase

import br.com.fundatec.profile.data.repository.UserRepository

class UserUsecase {

    private val repository: UserRepository by lazy {
        UserRepository()
    }

    suspend fun saveUser() {
        repository.saveUser()
    }

}