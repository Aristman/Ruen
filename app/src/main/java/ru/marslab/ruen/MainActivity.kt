package ru.marslab.ruen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var settings: SettingsPreferences

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val mode = if (settings.isDarkTheme()) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        val navController = navHostFragment.findNavController()
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.translator_fragment,
                R.id.navigationSituations,
                R.id.navigationSettings,
                R.id.nav_graph_repetition
            )
        )

        with(binding) {
            navView.setupWithNavController(navController)
            toolbar.setupWithNavController(navController, appBarConfiguration)
            navController.addOnDestinationChangedListener { _, _, arguments ->
                toolbar.isVisible = arguments?.getBoolean("showToolBar", true) ?: true
            }
        }
    }
}
