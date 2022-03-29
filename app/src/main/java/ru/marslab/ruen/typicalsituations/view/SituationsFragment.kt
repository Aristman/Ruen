package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentSituationsBinding
import ru.marslab.ruen.typicalsituations.model.Situations
import ru.marslab.ruen.typicalsituations.viewmodel.AppState
import ru.marslab.ruen.typicalsituations.viewmodel.SituationsViewModel

class SituationsFragment : ViewBindingFragment<FragmentSituationsBinding>(FragmentSituationsBinding::inflate) {

    private val situationsAdapter =
        SituationsAdapter(object : OnItemViewClickListener {
            override fun onItemViewClick(situations: Situations) {
                val manager = activity?.supportFragmentManager
                if (manager != null) {
                    val bundle = Bundle()
                    bundle.putParcelable(SituationsDetailsFragment.KEY_SITUATIONS, situations)
                    manager.beginTransaction()
                        .replace(R.id.container, SituationsDetailsFragment.newInstance(bundle))
                        .addToBackStack(R.string.empty_string.toString())
                        .commit()
                }
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

    companion object {
        fun newInstance(): SituationsFragment {
            return SituationsFragment()
        }
    }
}