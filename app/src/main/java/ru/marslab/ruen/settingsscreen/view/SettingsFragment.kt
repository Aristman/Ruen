package ru.marslab.ruen.settingsscreen.view

import android.os.Bundle
import android.view.View
import ru.marslab.ruen.databinding.FragmentSettingsBinding
import ru.marslab.ruen.typicalsituations.view.ViewBindingFragment

class SettingsFragment :
    ViewBindingFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    companion object {
        fun newInstance() = SettingsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.run {
            dailyWord.setOnCheckedChangeListener { p1, p2 ->

            }
            cardRepetition.setOnCheckedChangeListener { p1, p2 ->

            }
            popUpCardNotification.setOnCheckedChangeListener { p1, p2 ->

            }
            activateImages.setOnCheckedChangeListener { p1, p2 ->

            }
            activateImagesInCards.setOnCheckedChangeListener { p1, p2 ->

            }
            theme.setOnCheckedChangeListener { p1, p2 ->

            }
            fontSize.setOnCheckedChangeListener { p1, p2 ->

            }
        }
    }
}