package ru.istu.lab4mycitynavigator

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        bottomNavigationView = findViewById(R.id.bottomNavigation)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.highlightsFragment,
                R.id.aboutFragment,
                R.id.categoryFragment,
                R.id.settingsFragment,
            ),
            drawerLayout,
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.toolbar_open_drawer, R.string.toolbar_open_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (resources.getBoolean(R.bool.drawer_locked_open)) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN)
            drawerLayout.setScrimColor(Color.TRANSPARENT)
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.drawerCoffee -> navController.navigate(R.id.categoryFragment, CategoryFragment.bundle(1))
                R.id.drawerParks -> navController.navigate(R.id.categoryFragment, CategoryFragment.bundle(2))
                R.id.drawerMuseums -> navController.navigate(R.id.categoryFragment, CategoryFragment.bundle(3))
                R.id.drawerShopping -> navController.navigate(R.id.categoryFragment, CategoryFragment.bundle(4))
                R.id.drawerSettings -> navController.navigate(R.id.settingsFragment)
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.highlightsFragment, R.id.aboutFragment -> viewModel.lastBottomItemId = destination.id
            }
            if (resources.getBoolean(R.bool.drawer_locked_open) &&
                destination.id in setOf(R.id.homeFragment, R.id.highlightsFragment, R.id.aboutFragment, R.id.categoryFragment, R.id.settingsFragment)
            ) {
                toolbar.navigationIcon = null
            }
        }

        if (savedInstanceState != null) {
            bottomNavigationView.menu.findItem(viewModel.lastBottomItemId)?.isChecked = true
            if (viewModel.reopenDrawerAfterRotation && !resources.getBoolean(R.bool.drawer_locked_open)) {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.reopenDrawerAfterRotation = drawerLayout.isDrawerOpen(GravityCompat.START)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
