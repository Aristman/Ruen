package ru.marslab.ruen.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

internal typealias Inflater<B> = (LayoutInflater, ViewGroup?, Boolean) -> B

private const val ERROR_INFLATE_BINDING = "Binding is not inflate"

abstract class BaseFragment<B : ViewBinding>(
    private val bindingInflater: Inflater<B>
) : Fragment() {

    private var _binding: B? = null
    protected val binding: B
        get() = checkNotNull(_binding) { ERROR_INFLATE_BINDING }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun showToast(@StringRes stringId: Int) {
        this.showToast(getString(stringId))
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
