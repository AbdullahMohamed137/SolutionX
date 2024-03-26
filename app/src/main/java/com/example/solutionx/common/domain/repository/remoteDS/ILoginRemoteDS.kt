package com.example.solutionx.common.domain.repository.remoteDS

import com.example.solutionx.features.login.domain.models.response.Login
import com.example.solutionx.features.login.data.models.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

internal interface ILoginRemoteDS {

    fun loginEmail(email: String, password: String): UserDto

    @POST("api/login")
    suspend fun loginPhone(@Body userDto: UserDto): Response<Login>




    fun loginSocial(email: String, password: String): UserDto

}