package ru.marslab.ruen.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

abstract class BaseFragmentWithVM<VM : ViewModel, B : ViewBinding>(
    bindingInflater: Inflater<B>
) : BaseFragment<B>(bindingInflater) {

    protected abstract val viewModel: VM

    @OptIn(InternalCoroutinesApi::class)
    fun <D, E> observe(
        stateFlow: Flow<ViewState<D, E>>,
        eventHandler: (eventSate: ViewState<D, E>) -> Unit
    ) {
        lifecycleScope.launchWhenCreated {
            stateFlow
                .catch { }
                .collect {
                    eventHandler(it)
                }
        }
    }
}
