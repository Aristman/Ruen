package ru.marslab.ruen.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import ru.marslab.ruen.databinding.FragmentCardRepeatingBinding
import ru.marslab.ruen.viewmodels.CardRepeatingViewModel

class CardRepeatingFragment : BaseFragment<FragmentCardRepeatingBinding>() {
    private val viewModel: CardRepeatingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
                clearView()
                val card = appState.card
                tvWord.text = card.value
                tvTranscription.text = card.transcription
                card.translations?.forEach { translation ->
                    val textView = createTextView(translation.value)
                    llTranslationContainer.addView(textView)
                }
            }
            is CardRepeatingViewModel.AppState.NoCard -> {
                Toast.makeText(context, "no card", Toast.LENGTH_SHORT).show()
            }
            is CardRepeatingViewModel.AppState.Translation -> {
                llTranslationContainer.visibility = View.VISIBLE
                groupRememberBtn.visibility = View.VISIBLE
                btnShow.visibility = View.INVISIBLE
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