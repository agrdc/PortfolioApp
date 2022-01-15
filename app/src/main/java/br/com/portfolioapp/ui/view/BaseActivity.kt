package br.com.portfolioapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<GeneratedBindClass : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var dataBinding: GeneratedBindClass

    protected fun bindView(layoutId: Int) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId)
    }
}