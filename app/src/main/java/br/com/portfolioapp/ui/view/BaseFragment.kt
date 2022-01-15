package br.com.portfolioapp.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

class BaseFragment<GeneratedBindClass : ViewDataBinding> : Fragment() {
    protected lateinit var binding: GeneratedBindClass

    protected fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?, layoutId: Int
    ) {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    }
}