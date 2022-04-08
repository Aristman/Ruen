package ru.marslab.ruen.wordrepetition.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.R
import ru.marslab.ruen.wordrepetition.domain.Translation
import ru.marslab.ruen.databinding.FragmentCardAddBinding
import ru.marslab.ruen.view.ViewBindingFragment
import ru.marslab.ruen.wordrepetition.utilities.IImageLoader
import ru.marslab.ruen.wordrepetition.viewmodels.CardAddViewModel
import javax.inject.Inject

@AndroidEntryPoint
class CardAddFragment : ViewBindingFragment<FragmentCardAddBinding>(FragmentCardAddBinding::inflate) {
    private val viewModel: CardAddViewModel by viewModels()

    @Inject
    lateinit var imageLoader: IImageLoader

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner) { card -> handle(card) }
        val card = arguments?.getParcelable(CARD) ?: getTestCard()
        viewModel.init(card)
        setClickListener()
    }

    private fun setClickListener() = with(binding) {
        btnSave.setOnClickListener {
            val translationList = mutableListOf<String>()
            cgTranslations.checkedChipIds.forEach {
                translationList.add(cgTranslations.findViewById<Chip>(it).text.toString())
            }
            viewModel.save(translationList, etCustomTranslation.text.toString())
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
        with(card) {
            transcription?.let { tvTranscription.text = "[$it]" }
            imageUrl?.let {
                imageLoader.load(it, binding.ivPicture)
            }
            translations?.forEach { translation ->
                val chipTranslation =
                    layoutInflater.inflate(R.layout.chip_translation, cgTranslations, false) as Chip
                chipTranslation.apply {
                    text = translation.value
                }
                cgTranslations.addView(chipTranslation)
            }
        }
    }

    companion object {
        const val CARD = "card"
    }
}