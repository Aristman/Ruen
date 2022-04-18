package ru.marslab.ruen.core.presentation

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithVM<VM : ViewModel, B : ViewBinding>(
    bindingInflater: Inflater<B>
) : BaseFragment<B>(bindingInflater) {

    protected abstract val viewModel: VM
}
