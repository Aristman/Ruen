package ru.marslab.ruen.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import ru.marslab.ruen.Card
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentCardRepeatingBinding
import ru.marslab.ruen.utilities.IImageLoader
import ru.marslab.ruen.utilities.GlideImageLoader
import ru.marslab.ruen.viewmodels.CardRepeatingViewModel

class CardRepeatingFragment : BaseFragment<FragmentCardRepeatingBinding>() {
    private val viewModel: CardRepeatingViewModel by viewModels()
    private val imageLoader: IImageLoader = GlideImageLoader()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardRepeatingBinding.inflate(inflater, container, false)
        return binding.root
    }

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
                showCard(card)
            }
            is CardRepeatingViewModel.AppState.NoCard -> {
                startNoCardFragment()
            }
            is CardRepeatingViewModel.AppState.Translation -> {
                showTranslation()
            }
            is CardRepeatingViewModel.AppState.Loading -> {
                showLoading(true)
            }
        }
    }

    private fun showCard(card: Card) = with(binding){
        clearView()
        tvWord.text = card.value
        tvTranscription.text = card.transcription
        card.imageUrl?.let { loadImage(it) }
        card.translations?.forEach { translation ->
            val textView = createTextView(translation.value)
            llTranslationContainer.addView(textView)
        }
        showLoading(false)
    }

    private fun FragmentCardRepeatingBinding.showTranslation() {
        llTranslationContainer.visibility = View.VISIBLE
        groupRememberBtn.visibility = View.VISIBLE
        btnShow.visibility = View.INVISIBLE
    }

    private fun loadImage(url: String) = with(binding) {
        imageLoader.load(url, ivPicture)
    }

    private fun startNoCardFragment() {
        parentFragmentManager.commit {
            add(R.id.fragmentContainer, NoCardFragment())
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }


    private fun showLoading(show: Boolean) = with(binding) {
        loadingContainer.pbloading.apply {
            visibility = if (show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun clearView() = with(binding) {
        llTranslationContainer.removeAllViews()
        tvTranscription.text = ""
        tvWord.text = ""
    }

    private fun createTextView(label: String) = TextView(context).apply {
        text = label
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}