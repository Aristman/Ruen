package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collect
import ru.marslab.ruen.R
import ru.marslab.ruen.core.presentation.BaseFragmentWithVM
import ru.marslab.ruen.core.presentation.ViewEvent
import ru.marslab.ruen.databinding.FragmentSituationsBinding
import ru.marslab.ruen.typicalsituations.model.Situation
import ru.marslab.ruen.typicalsituations.viewmodel.SituationsViewModel

class SituationsFragment :
    BaseFragmentWithVM<SituationsViewModel, FragmentSituationsBinding>(FragmentSituationsBinding::inflate) {

    override val viewModel by viewModels<SituationsViewModel>()

    private val situationsAdapter =
        SituationsAdapter(object : OnItemViewClickListener {
            override fun onItemViewClick(situation: Situation) {
                findNavController().navigate(
                    R.id.action_navigationSituations_to_situationsDetailsFragment,
                    bundleOf(
                        SituationsDetailsFragment.KEY_SITUATIONS to situation
                    )
                )
            }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewSituations.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = situationsAdapter
        }
        lifecycleScope.launchWhenCreated {
            viewModel.event.collect { event ->
                when (event) {
                    ViewEvent.Loading -> {}
                    is ViewEvent.Error -> {
                        Toast.makeText(context, event.error.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.stateFlowHandler {
                situationsAdapter.setSituation(it.situations)
            }
        }
    }
}
