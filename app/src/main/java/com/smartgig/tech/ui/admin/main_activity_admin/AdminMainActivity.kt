package com.smartgig.tech.ui.admin.main_activity_admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityAdminMainBinding
import com.smartgig.tech.ui.admin.home_page.AdminHomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appConfig: AppBarConfiguration
    private lateinit var toogle:ActionBarDrawerToggle



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()

    }


    private fun setUpView() {
        setSupportActionBar(binding.toolbarAdmin)
        toogle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutAdmin,
            R.string.drawer_Open,
            R.string.drawer_Close

        )
        binding.drawerLayoutAdmin.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.adminHomeFragments ->{
//                    changeFragment(AdminHomeFragment::class.java)
                }
            }
            true

        }

    }

    private fun changeFragment(fragment: Class<AdminHomeFragment>) {

        TODO("Not yet implemented")
    }


    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return NavigationUI.navigateUp(navController,binding.drawerLayoutAdmin)
    }
}