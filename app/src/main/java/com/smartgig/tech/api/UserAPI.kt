package com.smartgig.tech.api

import com.smartgig.tech.models.UserLoginRequest
import com.smartgig.tech.models.UserLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("smg/admin/adminLogin")
    suspend fun loginUser(@Body userLoginRequest: UserLoginRequest): Response<UserLoginResponse>



}