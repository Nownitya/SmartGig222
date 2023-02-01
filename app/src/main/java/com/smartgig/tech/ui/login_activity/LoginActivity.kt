package com.smartgig.tech.ui.login_activity

import android.content.Intent
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.smartgig.tech.MainActivity
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityLoginBinding
import com.smartgig.tech.models.UserLoginRequest
import com.smartgig.tech.models.UserLoginResponse
import com.smartgig.tech.ui.admin.main_activity_admin.AdminMainActivity
import com.smartgig.tech.ui.hr.main_activity_hr.HRMainActivity
import com.smartgig.tech.ui.login_activity.viewmodel.AuthViewModel
import com.smartgig.tech.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val email = binding.emailET
//        val password = binding.passwordET
        val loginButton = binding.loginBtn
//        var pd = binding.pgBar


        loginButton.setOnClickListener {

            val validationResult = validateUserInput()

            if (validationResult.first) {

                doLogin()
            } else {
                Toast.makeText(this,validationResult.second,Toast.LENGTH_SHORT).show()

            }



        }

        bindObserver()

    }

    private fun getUserRequest(): UserLoginRequest {
        val email = binding.emailET.text.toString()
        val password = binding.passwordET.text.toString()

        return UserLoginRequest(email = email, password = password)
    }

    private fun validateUserInput(): Pair<Boolean, String> {
        val userRequest = getUserRequest()

        return authViewModel.validateCredentials(userRequest.email,userRequest. password)
    }

    private fun bindObserver() {
        authViewModel.userResponseLivedata.observe(this) {
            binding.pgBar.visibility = View.GONE
            when (it) {
                is NetworkResult.Loading -> {
                    showLoading()

                }
                is NetworkResult.Success -> {
                    // TODO:Token save
                    stopLoading()
                    processLogin(it.data)
                }
                is NetworkResult.Error -> {
                    processError(it.msg)

                }
                else -> {
                    stopLoading()
                }

            }


        }
    }

    private fun doLogin() {
        val email = binding.emailET.text.toString()
        val password = binding.passwordET.text.toString()
        authViewModel.loginUser(
            UserLoginRequest(
                email = email,
                password = password
            )
        )
    }


    private fun processLogin(data: UserLoginResponse?) {
        showToast("Msg:" +data?.msg)

        if (!(data?.token).isNullOrEmpty()) {
            data?.token.let {
                if ((data?.role) == "SUPER_ADMIN") {
                    navigateToAdmin()
                }else if ((data?.role) == "ADMIN") {
                    navigateToHR()
                }else if ((data?.role) == "Employee") {
                    navigateToEmployee()
                }
            }
        }




    }

    private fun showLoading() {
        binding.pgBar.visibility = View.VISIBLE
    }

    private fun stopLoading() {
        binding.pgBar.visibility = View.GONE
    }

    private fun processError(msg: String?) {
        showToast("Error: $msg")
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    private fun navigateToAdmin() {
        val intent = Intent(this, AdminMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }

    private fun navigateToHR() {
        val intent = Intent(this, HRMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }

    private fun navigateToEmployee() {
        val intent = Intent(this, AdminMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }
}