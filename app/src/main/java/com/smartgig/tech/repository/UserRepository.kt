package com.smartgig.tech.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smartgig.tech.api.UserAPI
import com.smartgig.tech.models.UserLoginRequest
import com.smartgig.tech.models.UserLoginResponse
import com.smartgig.tech.utils.Constants
import com.smartgig.tech.utils.Constants.TAG
import com.smartgig.tech.utils.NetworkResult
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class UserRepository @Inject constructor(private val userAPI: UserAPI) {

    private val _userResponseLiveData = MutableLiveData<NetworkResult<UserLoginResponse>>()
    val userResponseLiveData: LiveData<NetworkResult<UserLoginResponse>>
        get() = _userResponseLiveData


    suspend fun loginUser(userLoginRequest: UserLoginRequest) {

        _userResponseLiveData.postValue(NetworkResult.Loading())
        val response = userAPI.loginUser(userLoginRequest)

        handleLoginResponse(response)

        Log.d(TAG, response.body().toString())

    }

    private fun handleLoginResponse(response: Response<UserLoginResponse>) {

        if (response.code() == 200) {
            _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else {

//            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
//            _userResponseLiveData.postValue(NetworkResult.Error(errorObj.getString("msg")))
            _userResponseLiveData.postValue(NetworkResult.Error(response.message()))
        }
//        if (response.isSuccessful && response.body() != null) {
//            _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
//
//        } else if (response.errorBody() != null) {
//            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
//            _userResponseLiveData.postValue(NetworkResult.Error(errorObj.getString("msg")))
//
//        } else {
//            _userResponseLiveData.postValue(NetworkResult.Error("Error"))
//        }

//        if (response.code()==200) {
//            _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
//
//        }else if (response.errorBody() != null) {
//            _userResponseLiveData.postValue(NetworkResult.Error("Error"))
//
//        } else {
//            _userResponseLiveData.postValue(NetworkResult.Error(response?.message()))
//        }
    }
}