package ru.marslab.ruen.settingsscreen.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.SettingsPreferences
import ru.marslab.ruen.databinding.FragmentSettingsBinding
import ru.marslab.ruen.typicalsituations.view.ViewBindingFragment
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment :
    ViewBindingFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    @Inject
    lateinit var settings: SettingsPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStates()
        setListeners()
    }

    private fun initStates() {
        binding.run {
            dailyWord.setChecked(settings.isActiveDailyWord())
            cardRepetition.setChecked(settings.isActiveCardRepetition())
            popUpCardNotification.setChecked(settings.isActivePopupCardRepetition())
            activateImages.setChecked(settings.isShowAllImages())
            activateImagesInCards.setChecked(settings.isShowImagesInCards())
            theme.setChecked(settings.isDarkTheme())
            fontSize.setChecked(settings.isBigFontSize())
        }
    }

    private fun setListeners() {
        binding.run {
            dailyWord.setOnCheckedChangeListener { _, value ->
                settings.storeIsActiveDailyWord(value)
            }
            cardRepetition.setOnCheckedChangeListener { _, value ->
                settings.storeIsActiveCardRepetition(value)
            }
            popUpCardNotification.setOnCheckedChangeListener { _, value ->
                settings.storeIsActivePopupCardRepetition(value)
            }
            activateImages.setOnCheckedChangeListener { _, value ->
                settings.storeIsShowAllImages(value)
            }
            activateImagesInCards.setOnCheckedChangeListener { _, value ->
                settings.storeIsShowImagesInCards(value)
            }
            theme.setOnCheckedChangeListener { _, value ->
                val mode = if (value) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
                AppCompatDelegate.setDefaultNightMode(mode)
                settings.storeIsDarkTheme(value)
                activity?.recreate()
            }
            fontSize.setOnCheckedChangeListener { _, value ->
                settings.storeIsBigFontSize(value)
                activity?.recreate()
            }
        }
    }
}