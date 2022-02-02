package br.com.portfolioapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<GeneratedBindClass : ViewDataBinding> : Fragment() {
    lateinit var binding: GeneratedBindClass

    protected fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?, layoutId: Int
    ) : View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }
}