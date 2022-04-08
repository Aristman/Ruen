package ru.marslab.ruen.translation.views

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import ru.marslab.ruen.databinding.FragmentTranslationBinding
import ru.marslab.ruen.view.ViewBindingFragment

class TranslationFragment :
    ViewBindingFragment<FragmentTranslationBinding>(FragmentTranslationBinding::inflate) {

    val args: TranslationFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}