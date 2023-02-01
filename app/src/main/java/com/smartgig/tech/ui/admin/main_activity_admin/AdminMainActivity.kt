package com.smartgig.tech.ui.admin.main_activity_admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityAdminMainBinding
import com.smartgig.tech.databinding.FragmentAdminHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.dagger

@AndroidEntryPoint
class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //  Toolbar
        val toolbar = binding.toolbarAdmin
        toolbar.setNavigationIcon(R.drawable.hamburger)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        // NavigationView And Navigation Controller
        navigationView = binding.navigationViewAdmin
        navController = Navigation.findNavController(this, R.id.fragment_admin)

        //  AppBarConfiguration

        val drawerLayout = binding.drawerLayoutAdmin

//        val logout = findViewById<NavigationView>(R.id.logout_admin)

//        appConfig = AppBarConfiguration(
//            navController.graph,
//            drawerLayout
//        )

        appConfig = AppBarConfiguration(
            setOf(
                R.id.adminHomeFragments,
                R.id.adminLeaveRequestFragment,
                R.id.logout_admin
            ),
            drawerLayout
        )
        


//        appConfig = AppBarConfiguration(
//            setOf(
//                R.id.adminHomeFragments,
//                R.id.adminLeaveRequestFragment,
//
//            ),drawerLayout
//        )

//        logout.setOnClickListener {
//            Toast.makeText(this,"Logout Button", Toast.LENGTH_SHORT).show()
//        }




        NavigationUI.setupWithNavController(binding.toolbarAdmin, navController, appConfig)
//        NavigationUI.setupWithNavController(binding.toolbarAdmin, navController, appConfig)
        navigationView.setupWithNavController(navController)
    }




    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return NavigationUI.navigateUp(navController,binding.drawerLayoutAdmin)
    }
}