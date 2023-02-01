package com.smartgig.tech.ui.employee.main_activity_employee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityEmployeeMainBinding
import com.smartgig.tech.databinding.FragmentAdminHomeBinding
import com.smartgig.tech.databinding.FragmentEmployeeHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmployeeMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEmployeeMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //  Toolbar
        val toolbar = binding.toolbarEmployee
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        // NavigationView And Navigation Controller
        navigationView = binding.navigationViewEmployee
        navController = Navigation.findNavController(this, R.id.fragment_admin)

        //  AppBarConfiguration
        val drawerLayout = binding.drawerLayoutEmployee
        appConfig = AppBarConfiguration(
            setOf(
                R.id.adminHomeFragments,
                R.id.adminLeaveRequestFragment

            ),drawerLayout
        )

        NavigationUI.setupWithNavController(binding.toolbarEmployee, navController, appConfig)
        navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return NavigationUI.navigateUp(navController,binding.drawerLayoutEmployee)
    }
}