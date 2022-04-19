package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.View
import ru.marslab.ruen.core.presentation.BaseFragment
import ru.marslab.ruen.databinding.FragmentSituationsDetailsBinding
import ru.marslab.ruen.typicalsituations.model.Situation

class SituationsDetailsFragment :
    BaseFragment<FragmentSituationsDetailsBinding>(FragmentSituationsDetailsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val situations = arguments?.getParcelable(KEY_SITUATIONS) as? Situation
        if (situations != null) {
            setData(situations)
        }
    }

    private fun setData(situationData: Situation) {
        binding.apply {
            situation.setImageResource(situationData.image)
            firstRussianExample.text = situationData.firstRusPhrase
            firstEnglishExample.text = situationData.firstEngPhrase
            secondRussianExample.text = situationData.secondRusPhrase
            secondEnglishExample.text = situationData.secondEngPhrase
        }
    }

    companion object {
        const val KEY_SITUATIONS = "KEY_SITUATIONS"
    }
}
