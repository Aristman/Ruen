package ru.marslab.ruen.translation.views

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentTranslationBinding
import ru.marslab.ruen.data.retrofit.beans.RetrofitWord
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
        setTvWord(word)
        viewModel.translate(word).observe(viewLifecycleOwner) { state -> handleState(state) }
        setListeners()
    }

    private fun setTvWord(word: String) {
        binding.tvWord.text = word
    }

    private fun setListeners() {
        with(binding) {
            ivSound.setOnClickListener {
                viewModel.voiceClicked()
            }
            btnTranslate.setOnClickListener {
                val query = searchQuery.text.toString().trim()
                searchQuery.text = null
                if (query.isNotEmpty()) {
                    setTvWord(query)
                    viewModel.translate(query)
                } else {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.write_a_word),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            btnCreateCard.setOnClickListener {
                viewModel.createCardClicked()
            }
        }
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
            is AppState.Loading -> {
                showLoading(true)
                clearFields()
            }
            is AppState.CreatedCard -> {
                val directions =
                    TranslationFragmentDirections.actionNavigationTranslationToCardAddFragment(state.card)
                findNavController().navigate(directions)
            }
        }
    }

    private fun clearFields() = with(binding) {
        tvTranscription.text = null
        wordContainer.removeAllViews()
    }

    private fun setData(word: RetrofitWord) = with(binding) {
        if (word.meanings.size > 0) {
            val meanings = word.meanings
            val meaning = meanings[0]
            imageLoader.load(meaning.imageUrl, ivPicture)
            tvTranscription.text = "[${meaning.transcription}]"
            meanings.forEach {
                wordContainer.addView(createTextView(it.translation.text))
            }
        }
    }

    private fun createTextView(label: String): TextView {
        val textView =
            layoutInflater.inflate(R.layout.text_chip, binding.root, false) as TextView
        textView.text = label
        return textView
    }

    private fun showLoading(show: Boolean) = with(binding) {
        loadingContainer.loading.visibility = if (show) View.VISIBLE else View.GONE
    }
}