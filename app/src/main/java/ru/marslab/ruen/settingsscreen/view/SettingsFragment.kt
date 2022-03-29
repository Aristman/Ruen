package ru.marslab.ruen.settingsscreen.view

import android.os.Bundle
import android.view.View
import ru.marslab.ruen.App
import ru.marslab.ruen.databinding.FragmentSettingsBinding
import ru.marslab.ruen.typicalsituations.view.ViewBindingFragment

class SettingsFragment :
    ViewBindingFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    private val settings = App.instance.setting

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
//                activity?.setTheme()
                settings.storeIsDarkTheme(value)
                activity?.recreate()
            }
            fontSize.setOnCheckedChangeListener { _, value ->
                settings.storeIsBigFontSize(value)
                activity?.recreate()
            }
        }
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}