package com.smartgig.tech.ui.login_activity.viewmodel

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartgig.tech.models.UserLoginRequest
import com.smartgig.tech.models.UserLoginResponse
import com.smartgig.tech.repository.UserRepository
import com.smartgig.tech.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userResponseLivedata: LiveData<NetworkResult<UserLoginResponse>>
    get() = userRepository.userResponseLiveData

    fun loginUser(userLoginRequest: UserLoginRequest) {
        viewModelScope.launch {
            userRepository.loginUser(userLoginRequest)

        }
    }

    fun validateCredentials(email: String, password: String): Pair<Boolean, String> {
        var result = Pair(true, "")
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            result = Pair(false, "Please Provide a valid Email or Password")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            result = Pair(false, "Please Provide a valid Email")
        } else if (password.length <= 5) {
            result = Pair(false, "Please Provide a valid Password")
        }
        return result

    }

}