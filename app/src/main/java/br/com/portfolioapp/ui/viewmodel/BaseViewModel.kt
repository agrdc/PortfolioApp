package br.com.portfolioapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {

    protected val job = Job()
    protected val scopeIO = CoroutineScope(job + Dispatchers.IO)

    val successLiveData = MutableLiveData<Any?>()
    val errorLiveData = MutableLiveData<String>()
    val isLoadingLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}