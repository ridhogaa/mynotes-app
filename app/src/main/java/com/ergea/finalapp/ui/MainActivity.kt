package com.ergea.finalapp.ui

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ergea.finalapp.R
import com.ergea.finalapp.ui.add.AddDialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
//    private lateinit var bottomNav: BottomNavigationView
//    private lateinit var topNav: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerViewHome) as NavHostFragment

        navController = navHostFragment.navController

//        bottomNav = findViewById(R.id.bottomNavigationView)
//        topNav = findViewById(R.id.top_app_bar)

//        val appBarConfiguration = AppBarConfiguration.Builder(
//            R.id.homeFragment,
//            0,
//            R.id.profileFragment
//        ).build()
//
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        bottomNav.setupWithNavController(navController)
//        topNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> hideBottomNav(true)
                R.id.registerFragment -> hideBottomNav(true)
                R.id.splashFragment -> hideBottomNav(true)
                else -> hideBottomNav(false)
            }
        }
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            AddDialogFragment().show(supportFragmentManager, "Add")
        }
    }

    private fun hideBottomNav(hide: Boolean) {
        if (hide) {
            findViewById<CoordinatorLayout>(R.id.coordinator_bottom).visibility = View.GONE
//            findViewById<CoordinatorLayout>(R.id.coordinator_top).visibility = View.GONE
        } else {
            findViewById<CoordinatorLayout>(R.id.coordinator_bottom).visibility = View.VISIBLE
//            findViewById<CoordinatorLayout>(R.id.coordinator_top).visibility = View.VISIBLE

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}