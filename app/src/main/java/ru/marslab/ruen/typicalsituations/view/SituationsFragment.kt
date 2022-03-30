package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentSituationsBinding
import ru.marslab.ruen.typicalsituations.model.Situations
import ru.marslab.ruen.typicalsituations.viewmodel.AppState
import ru.marslab.ruen.typicalsituations.viewmodel.SituationsViewModel

class SituationsFragment :
    ViewBindingFragment<FragmentSituationsBinding>(FragmentSituationsBinding::inflate) {

    private val situationsAdapter =
        SituationsAdapter(object : OnItemViewClickListener {
            override fun onItemViewClick(situations: Situations) {
                findNavController().navigate(
                    R.id.action_navigationSituations_to_situationsDetailsFragment,
                    bundleOf(
                        SituationsDetailsFragment.KEY_SITUATIONS to situations
                    )
                )
            }

        })
    private lateinit var viewModel: SituationsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewSituations.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = situationsAdapter
        }
        viewModel = ViewModelProvider(this)[SituationsViewModel::class.java]
        viewModel.apply {
            liveDataToObserve.observe(viewLifecycleOwner) { renderData(it) }
            getSituations()
        }
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Success -> {
                val situations = data.situations
                situationsAdapter.setSituation(situations)
            }
            // TODO
            is AppState.Loading -> {

            }
            // TODO SwipeRefreshLayout
            is AppState.Error -> {
                Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}