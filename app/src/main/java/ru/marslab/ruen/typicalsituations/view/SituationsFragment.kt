package ru.marslab.ruen.typicalsituations.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentSituationsBinding
import ru.marslab.ruen.typicalsituations.model.Situations
import ru.marslab.ruen.typicalsituations.viewmodel.AppState
import ru.marslab.ruen.typicalsituations.viewmodel.SituationsViewModel

class SituationsFragment : Fragment() {

    private var _binding: FragmentSituationsBinding? = null
    private val binding get() = _binding!!
    private var situationsList: List<Situations> = listOf()
    private val situationsAdapter =
        SituationsAdapter(situationsList, object : OnItemViewClickListener {
            override fun onItemViewClick(situations: Situations) {
                val manager = activity?.supportFragmentManager
                if (manager != null) {
                    val bundle = Bundle()
                    bundle.putParcelable(SituationsDetailsFragment.KEY_SITUATIONS, situations)
                    manager.beginTransaction()
                        .replace(R.id.container, SituationsDetailsFragment.newInstance(bundle))
                        .addToBackStack(EMPTY_STRING)
                        .commit()
                }
            }

        })
    private lateinit var viewModel: SituationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSituationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewSituations.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = situationsAdapter
        }
        viewModel = ViewModelProvider(this)[SituationsViewModel::class.java]
        viewModel.apply {
            getLiveData().observe(viewLifecycleOwner) { renderData(it) }
            getSituations()
        }
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Success -> {
                val situations = data.situations
                situationsAdapter.setSituation(situations)
            }
            is AppState.Error -> {
                Toast.makeText(context, ERROR, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EMPTY_STRING = ""
        const val ERROR = "Error"
        fun newInstance(): SituationsFragment {
            return SituationsFragment()
        }
    }
}