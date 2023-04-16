package br.com.fundatec.profile.data.remote

import br.com.fundatec.login.data.response.LoginResponse
import retrofit2.http.POST
import retrofit2.http.Body

interface UserProfileApi {

    @POST("api/login")
    suspend fun createUser(
        @Body userRequest: UserRequest,
    ): LoginResponse

}