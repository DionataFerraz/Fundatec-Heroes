package br.com.fundatec.login.data.remote

import br.com.fundatec.login.data.response.LoginResponse
import br.com.fundatec.profile.data.remote.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApi {

    @GET("api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ): LoginResponse

    @POST("api/login")
    suspend fun createUser(
        @Body userRequest: UserRequest,
    ): Response<LoginResponse>

}