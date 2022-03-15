package ru.marslab.ruen.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import ru.marslab.ruen.Card
import ru.marslab.ruen.R
import ru.marslab.ruen.Translation
import ru.marslab.ruen.databinding.FragmentCardAddBinding
import ru.marslab.ruen.viewmodels.CardAddViewModel

class CardAddFragment : Fragment() {
    private lateinit var binding: FragmentCardAddBinding
    private val viewModel: CardAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner) { card -> handle(card) }
        val card = arguments?.getParcelable(CARD) ?: getTestCard()
        viewModel.init(card)
        saveButtonListener()
    }

    private fun saveButtonListener() {
        binding.btnSave.setOnClickListener{
            viewModel.save(listOf(),"")
        }
    }

    private fun getTestCard() = Card(
        value = "word",
        transcription = "w:ord",
        translations = mutableListOf(
            Translation(value = "Слово"),
            Translation(value = "известие"),
            Translation(value = "текстовый"),
            Translation(value = "словесный"),
        )
    )


    private fun handle(card: Card) = with(binding) {
        tvWord.text = card.value
        card.transcription?.let { tvTranscription.text = it }

        card.translations?.forEach{ translation->
            val chipTranslation = layoutInflater.inflate(R.layout.chip_translation, cgTranslations, false)
            chipTranslation.findViewById<Chip>(R.id.chipTranslation).apply {
                text=translation.value
            }
            cgTranslations.addView(chipTranslation)
        }
    }

    companion object {
        private const val CARD = "card"
        fun getInstance(card: Card): Fragment = CardAddFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CARD, card)
            }
        }
    }
}