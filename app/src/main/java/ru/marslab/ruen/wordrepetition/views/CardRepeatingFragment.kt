package ru.marslab.ruen.wordrepetition.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.DrawableUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.R
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.databinding.FragmentCardRepeatingBinding
import ru.marslab.ruen.view.ViewBindingFragment
import ru.marslab.ruen.wordrepetition.utilities.IImageLoader
import ru.marslab.ruen.wordrepetition.viewmodels.CardRepeatingViewModel
import javax.inject.Inject

@AndroidEntryPoint
class CardRepeatingFragment :
    ViewBindingFragment<FragmentCardRepeatingBinding>(FragmentCardRepeatingBinding::inflate) {
    @Inject
    lateinit var imageLoader: IImageLoader
    private val viewModel: CardRepeatingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)
        init()
        setListeners()
    }

    private fun setListeners() = with(binding) {
        ivSound.setOnClickListener {
            viewModel.speechClicked()
        }
        btnShow.setOnClickListener {
            viewModel.showClicked()
        }
        btnRemember.setOnClickListener {
            viewModel.rememberClicked()
        }
        btnNotRemember.setOnClickListener {
            viewModel.notRememberClicked()
        }
    }

    private fun init() {
        viewModel.liveData.observe(viewLifecycleOwner) { handleData(it) }
        viewModel.init()
    }

    private fun handleData(appState: CardRepeatingViewModel.AppState) = with(binding) {
        when (appState) {
            is CardRepeatingViewModel.AppState.Success -> {
                val card = appState.card
                setVisibilityTranslation(false)
                showCard(card)
            }
            is CardRepeatingViewModel.AppState.NoCard -> {
                startNoCardFragment()
            }
            is CardRepeatingViewModel.AppState.Translation -> {
                setVisibilityTranslation()
            }
            is CardRepeatingViewModel.AppState.Loading -> {
                showLoading(true)
            }
        }
    }

    private fun showCard(card: Card) = with(binding) {
        clearView()
        tvWord.text = card.value
        tvTranscription.text = card.transcription
        card.imageUrl?.let { loadImage(it) }
        card.translations?.forEach { translation ->
            val textView = createTextView(translation.value)
            linearTranslationContainer.addView(textView)
        }
        showLoading(false)
    }

    private fun setVisibilityTranslation(visible: Boolean = true) = with(binding) {
        val visibility = getVisibility(visible)
        linearTranslationContainer.visibility = visibility
        groupRememberBtns.visibility = visibility
        btnShow.visibility = getVisibility(!visible)
    }

    private fun getVisibility(visible: Boolean) = if (visible) View.VISIBLE else View.GONE

    private fun loadImage(url: String) = with(binding) {
        imageLoader.load(url, ivPicture)
    }

    private fun startNoCardFragment() {
        val directions =
            CardRepeatingFragmentDirections.actionCardRepeatingFragmentToNoCardFragment()
        findNavController().navigate(directions)
    }


    private fun showLoading(show: Boolean) = with(binding) {
        loadingContainer.loading.apply {
            visibility = if (show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun clearView() = with(binding) {
        linearTranslationContainer.removeAllViews()
        tvTranscription.text = ""
        tvWord.text = ""
        ivPicture.setImageDrawable(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.noimage
            )
        )
    }

    private fun createTextView(label: String) = TextView(context).apply {
        text = label
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}