package br.com.portfolioapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {
    val successLiveData = MutableLiveData<Any?>()
    val errorLiveData = MutableLiveData<String>()
    val isLoadingLiveData = MutableLiveData<Boolean>()
}