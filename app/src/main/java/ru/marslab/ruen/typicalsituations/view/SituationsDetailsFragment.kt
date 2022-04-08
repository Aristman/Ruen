package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentSituationsDetailsBinding
import ru.marslab.ruen.typicalsituations.model.Situations
import ru.marslab.ruen.view.ViewBindingFragment

class SituationsDetailsFragment : ViewBindingFragment<FragmentSituationsDetailsBinding>(FragmentSituationsDetailsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val situations = arguments?.getParcelable(KEY_SITUATIONS) as? Situations
        if (situations != null) {
            setData(situations)
        }
    }

    private fun setData(situationsData: Situations) {
        binding.apply {
            context?.let {
                Glide.with(it)
                    .load(situationsData.situationImage)
                    .placeholder(R.drawable.empty)
                    .into(situation)
            }
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