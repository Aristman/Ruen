package ru.marslab.ruen.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import ru.marslab.ruen.adapters.RVCardsAdapter
import ru.marslab.ruen.databinding.FragmentCardsBinding
import ru.marslab.ruen.viewmodels.CardsViewModel

class CardsFragment : BaseFragment<FragmentCardsBinding>() {
    private var adapter: RVCardsAdapter? = null
    private val viewModel: CardsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        init()

    }

    private fun init() {
        viewModel.getLiveData().observe(viewLifecycleOwner) {
            handleViewState(it)
        }
        viewModel.updateData()
    }

    private fun handleViewState(viewState: CardsViewModel.ViewState) {
        when (viewState) {
            is CardsViewModel.ViewState.Success -> adapter?.updateCards(viewState.cards)
            is CardsViewModel.ViewState.Error -> Toast.makeText(
                context,
                viewState.error.message,
                Toast.LENGTH_SHORT
            ).show()
            is CardsViewModel.ViewState.Loading -> Toast.makeText(
                context,
                "loading",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun setAdapter() = with(binding) {
        adapter = RVCardsAdapter()
        rvCards.adapter = adapter
    }
}