package com.smartgig.tech.ui.admin.main_activity_admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityAdminMainBinding
import com.smartgig.tech.databinding.ActivityEmployeeMainBinding
import com.smartgig.tech.ui.admin.home_page.AdminHomeFragment
import com.smartgig.tech.ui.admin.leave_request.AdminLeaveRequestFragment
import com.smartgig.tech.ui.login_activity.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

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
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        // NavigationView And Navigation Controller
        navigationView = binding.navigationViewAdmin
        navController = Navigation.findNavController(this, R.id.fragment_admin)

        //  AppBarConfiguration

        val drawerLayout = binding.drawerLayoutAdmin
        appConfig = AppBarConfiguration(
            navController.graph,drawerLayout
        )
//        val drawerLayout = binding.drawerLayoutAdmin
//        appConfig = AppBarConfiguration(
//            setOf(
//                R.id.adminHomeFragments,
//                R.id.adminLeaveRequestFragment
//
//            ),drawerLayout
//        )



        NavigationUI.setupWithNavController(binding.toolbarAdmin, navController, appConfig)
        navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return NavigationUI.navigateUp(navController,binding.drawerLayoutAdmin)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}