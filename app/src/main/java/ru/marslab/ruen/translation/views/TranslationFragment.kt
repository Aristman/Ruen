package ru.marslab.ruen.translation.views

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentTranslationBinding
import ru.marslab.ruen.translation.models.retrofit.beans.Word
import ru.marslab.ruen.translation.viewmodels.AppState
import ru.marslab.ruen.translation.viewmodels.TranslationViewModel
import ru.marslab.ruen.view.ViewBindingFragment
import ru.marslab.ruen.wordrepetition.utilities.IImageLoader
import javax.inject.Inject

@AndroidEntryPoint
class TranslationFragment :
    ViewBindingFragment<FragmentTranslationBinding>(FragmentTranslationBinding::inflate) {

    private val viewModel: TranslationViewModel by viewModels()
    private val args: TranslationFragmentArgs by navArgs()

    @Inject
    lateinit var imageLoader: IImageLoader

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)
        val word = args.word
        viewModel.translate(word).observe(viewLifecycleOwner) { state -> handleState(state) }
    }

    private fun handleState(state: AppState) = with(binding) {
        showLoading(false)
        when (state) {
            is AppState.Success -> {
                setData(state.word)

            }
            is AppState.NotFound -> Toast.makeText(
                context,
                requireContext().getString(R.string.not_found),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setData(word: Word) = with(binding) {
        tvWord.text = word.text
        if (word.meanings.size > 0) {
            val meanings = word.meanings
            val meaning = meanings[0]
            imageLoader.load("https:${meaning.imageUrl}", ivPicture)
            tvTranscription.text = "[${meaning.transcription}]"
            meanings.forEach {
                wordContainer.addView(createChipTextView(it.translation.text))
            }
        }
    }

    private fun createChipTextView(label: String) = Button(requireContext()).apply {
        text = label
        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent)
        background = resources.getDrawable(R.drawable.background_oval, null)
    }

    private fun showLoading(show: Boolean) = with(binding) {
        loadingContainer.loading.visibility = if (show) View.VISIBLE else View.GONE
    }
}