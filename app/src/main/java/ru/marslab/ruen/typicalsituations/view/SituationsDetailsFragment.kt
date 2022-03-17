package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.marslab.ruen.databinding.FragmentSituationsDetailsBinding
import ru.marslab.ruen.typicalsituations.model.Situations

class SituationsDetailsFragment : Fragment() {

    private var _binding: FragmentSituationsDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSituationsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_SITUATIONS = "KEY_SITUATIONS"
        fun newInstance(bundle: Bundle): SituationsDetailsFragment {
            val fragment = SituationsDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}