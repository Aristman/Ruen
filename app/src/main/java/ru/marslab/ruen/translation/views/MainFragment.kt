package ru.marslab.ruen.translation.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.FragmentMainBinding
import ru.marslab.ruen.view.ViewBindingFragment

class MainFragment : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() = with(binding) {
        btnTranslate.setOnClickListener {
            val query = searchQuery.text.toString().trim()
            if (query.isEmpty()) {
                Toast.makeText(
                    context,
                    resources.getString(R.string.write_a_word),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val directions =
                    MainFragmentDirections.actionMainFragmentToNavigationTranslation(word = query)
                findNavController().navigate(directions)
                searchQuery.text = null
            }
        }
    }
}