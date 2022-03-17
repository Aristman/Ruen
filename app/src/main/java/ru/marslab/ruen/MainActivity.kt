package ru.marslab.ruen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.marslab.ruen.databinding.ActivityMainBinding
import ru.marslab.ruen.typicalsituations.view.SituationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, SituationsFragment.newInstance())
                .addToBackStack("")
                .commit()
        }
    }
}
