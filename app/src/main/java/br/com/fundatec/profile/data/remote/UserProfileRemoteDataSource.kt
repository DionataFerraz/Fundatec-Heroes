package br.com.fundatec.profile.data.remote

import br.com.fundatec.profile.domain.model.UserModel

interface UserProfileRemoteDataSource {
    suspend fun createUser(userModel: UserModel)
}
