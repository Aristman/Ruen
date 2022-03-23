package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.marslab.ruen.databinding.FragmentSituationsDetailsBinding
import ru.marslab.ruen.typicalsituations.model.Situations

class SituationsDetailsFragment : ViewBindingFragment<FragmentSituationsDetailsBinding>() {

    override val inflateBinding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSituationsDetailsBinding =
        FragmentSituationsDetailsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val situations = arguments?.getParcelable(KEY_SITUATIONS) as? Situations
        if (situations != null) {
            setData(situations)
        }
    }

    private fun setData(situationsData: Situations) {
        binding.apply {
            situation.setImageResource(situationsData.situationImage)
            firstRussianExample.text = situationsData.firstRusPhrase
            firstEnglishExample.text = situationsData.firstEngPhrase
            secondRussianExample.text = situationsData.secondRusPhrase
            secondEnglishExample.text = situationsData.secondEngPhrase
        }
    }

    companion object {
        const val KEY_SITUATIONS = "KEY_SITUATIONS"
        fun newInstance(bundle: Bundle): SituationsDetailsFragment {
            return SituationsDetailsFragment().apply { arguments = bundle }
        }
    }
}