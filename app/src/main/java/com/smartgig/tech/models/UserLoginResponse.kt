package com.smartgig.tech.models

import com.google.gson.annotations.SerializedName

data class UserLoginResponse(
    @SerializedName("adminId")
    val adminId: Int,
    @SerializedName("adminName")
    val adminName: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("isPasswordChanged")
    val isPasswordChanged: Boolean = false,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("token")
    val token: String
)
