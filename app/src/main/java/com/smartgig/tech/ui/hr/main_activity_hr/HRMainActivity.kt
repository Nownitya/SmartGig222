package com.smartgig.tech.ui.hr.main_activity_hr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityHrMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HRMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHrMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHrMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //  Toolbar
        val toolbar = binding.toolbarHr
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        // NavigationView And Navigation Controller
        navigationView = binding.navigationViewHr
        navController = Navigation.findNavController(this, R.id.fragment_admin)

        //  AppBarConfiguration

        val drawerLayout = binding.drawerLayoutHr
        appConfig = AppBarConfiguration(
            navController.graph,drawerLayout
        )
//        val drawerLayout = binding.drawerLayoutHr
//        appConfig = AppBarConfiguration(
//            setOf(
//                R.id.adminHomeFragments,
//                R.id.adminLeaveRequestFragment
//
//            ),drawerLayout
//        )

        NavigationUI.setupWithNavController(binding.toolbarHr, navController, appConfig)
        navigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return NavigationUI.navigateUp(navController,binding.drawerLayoutHr)
    }
}