package br.com.portfolioapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<GeneratedBindClass : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: GeneratedBindClass

    protected fun bindView(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}