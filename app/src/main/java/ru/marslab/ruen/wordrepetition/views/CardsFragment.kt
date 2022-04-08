package ru.marslab.ruen.wordrepetition.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.marslab.ruen.wordrepetition.adapters.RVCardsAdapter
import ru.marslab.ruen.databinding.FragmentCardsBinding
import ru.marslab.ruen.view.ViewBindingFragment
import ru.marslab.ruen.wordrepetition.viewmodels.CardsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class CardsFragment : ViewBindingFragment<FragmentCardsBinding>(FragmentCardsBinding::inflate) {
    @Inject
    lateinit var adapter: RVCardsAdapter
    private val viewModel: CardsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        init()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        btnStartRepeating.setOnClickListener {
            viewModel.startRepeatingClicked()
        }
        btnCreateNewCard.setOnClickListener {
            testStartFragment()
        }
    }

    private fun testStartFragment() {
        val directions = CardsFragmentDirections.actionCardsFragmentToCardAddFragment()
        findNavController().navigate(directions)
    }

    private fun init() {
        viewModel.getLiveData().observe(viewLifecycleOwner) {
            handleViewState(it)
        }
        viewModel.updateData()
    }

    private fun handleViewState(viewState: CardsViewModel.ViewState) {
        when (viewState) {
            is CardsViewModel.ViewState.Success -> {
                adapter.updateCards(viewState.cards)
                showLoading(false)
            }
            is CardsViewModel.ViewState.Error -> {
                showLoading(false)
                Toast.makeText(
                    context,
                    viewState.error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            is CardsViewModel.ViewState.Loading -> {
                showLoading(true)
            }
            is CardsViewModel.ViewState.CardRepeating -> {
                startRememberFragment()
            }
        }
    }

    private fun startRememberFragment() {
        val directions = CardsFragmentDirections.actionCardsFragmentToCardRepeatingFragment()
        findNavController().navigate(directions)
    }

    private fun showLoading(show: Boolean) = with(binding) {
        loadingContainer.loading.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun setAdapter() = with(binding) {
        adapter = RVCardsAdapter()
        rvCards.adapter = adapter
    }
}