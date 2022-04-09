package ru.marslab.ruen.translation.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentMainBinding
import ru.marslab.ruen.translation.viewmodels.MainAppState
import ru.marslab.ruen.translation.viewmodels.MainViewModel
import ru.marslab.ruen.translation.views.adapters.HistoryRVAdapter
import ru.marslab.ruen.view.ViewBindingFragment
import ru.marslab.ruen.wordrepetition.domain.Card
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var historyAdapter: HistoryRVAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveDate().observe(viewLifecycleOwner) { handleState(it) }
        viewModel.init()
        setListeners()
        setAdapter()
    }

    private fun setAdapter() = with(binding) {
        historyAdapter.setClickListener { query ->
            navigateToTranslation(query)
        }
        historyList.adapter = historyAdapter
    }

    private fun setListeners() = with(binding) {
        btnTranslate.setOnClickListener {
            viewModel.translateClicked(searchQuery.text.toString())
        }
    }

    private fun handleState(state: MainAppState) {
        when (state) {
            is MainAppState.NoWord -> showMessageWriteWord()
            is MainAppState.Translation -> navigateToTranslation(state.word)
            is MainAppState.History -> historyAdapter.updateWordsList(state.words)
            is MainAppState.LastCard -> setLastCard(state.card)
            is MainAppState.CardNull -> setNullCard()
        }
    }

    private fun setLastCard(card: Card) = with(binding) {
        wordOfTheDay.apply {
            engWord.text = card.value
            card.transcription?.let { rusWord.text = it }
        }
    }

    private fun setNullCard() = with(binding) {
        wordOfTheDay.engWord.text = resources.getString(R.string.no_cards)
    }

    private fun navigateToTranslation(query: String) = with(binding) {
        val directions =
            MainFragmentDirections.actionMainFragmentToNavigationTranslation(word = query)
        findNavController().navigate(directions)
        searchQuery.text = null
    }

    private fun showMessageWriteWord() {
        Toast.makeText(
            context,
            resources.getString(R.string.write_a_word),
            Toast.LENGTH_SHORT
        ).show()
    }
}