package ru.marslab.ruen.views

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>() : Fragment() {
    protected var _binding: T? = null
    protected val binding by lazy { _binding!! }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}