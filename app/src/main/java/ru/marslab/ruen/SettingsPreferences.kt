package ru.marslab.ruen

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsPreferences @Inject constructor(@ApplicationContext context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(prefsKey, Context.MODE_PRIVATE)

    //region Daily word
    fun storeIsActiveDailyWord(value: Boolean) {
        prefs.edit().putBoolean(IS_ACTIVE_DAILY_WORD_KEY, value).apply()
    }

    fun isActiveDailyWord() = prefs.getBoolean(IS_ACTIVE_DAILY_WORD_KEY, true)
    //endregion

    //region Card repetition
    fun storeIsActiveCardRepetition(value: Boolean) {
        prefs.edit().putBoolean(IS_ACTIVE_CARD_REPETITION_KEY, value).apply()
    }

    fun isActiveCardRepetition() = prefs.getBoolean(IS_ACTIVE_CARD_REPETITION_KEY, true)
    //endregion

    //region Pop-up in card repetition
    fun storeIsActivePopupCardRepetition(value: Boolean) {
        prefs.edit().putBoolean(IS_ACTIVE_POPUP_CARD_REPETITION_KEY, value).apply()
    }

    fun isActivePopupCardRepetition() = prefs.getBoolean(IS_ACTIVE_POPUP_CARD_REPETITION_KEY, true)
    //endregion

    //region Show all images
    fun storeIsShowAllImages(value: Boolean) {
        prefs.edit().putBoolean(IS_ACTIVE_ALL_IMAGES_KEY, value).apply()
    }

    fun isShowAllImages() = prefs.getBoolean(IS_ACTIVE_ALL_IMAGES_KEY, true)
    //endregion

    //region Show images in cards
    fun storeIsShowImagesInCards(value: Boolean) {
        prefs.edit().putBoolean(IS_ACTIVE_IMAGES_IN_CARDS_KEY, value).apply()
    }

    fun isShowImagesInCards() = prefs.getBoolean(IS_ACTIVE_IMAGES_IN_CARDS_KEY, true)
    //endregion

    //region Dark theme
    fun storeIsDarkTheme(value: Boolean) {
        prefs.edit().putBoolean(IS_DARK_THEME_KEY, value).apply()
    }

    fun isDarkTheme() = prefs.getBoolean(IS_DARK_THEME_KEY, false)
    //endregion

    //region Big font size
    fun storeFontSize(value: Int) {
        prefs.edit().putInt(FONT_SIZE_KEY, value).apply()
    }

    fun getFontSize() = prefs.getInt(FONT_SIZE_KEY, 1)
    //endregion

    private companion object {
        const val prefsKey = "SETTINGS"

        const val IS_ACTIVE_DAILY_WORD_KEY = "is_active_daily_word"
        const val IS_ACTIVE_CARD_REPETITION_KEY = "is_active_card_repetition"
        const val IS_ACTIVE_POPUP_CARD_REPETITION_KEY = "is_active_popup_card_repetition"
        const val IS_ACTIVE_ALL_IMAGES_KEY = "is_active_all_images"
        const val IS_ACTIVE_IMAGES_IN_CARDS_KEY = "is_active_images_in_cards"
        const val IS_DARK_THEME_KEY = "is_dark_theme"
        const val FONT_SIZE_KEY = "font_size"
    }
}
