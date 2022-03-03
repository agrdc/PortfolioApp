package br.com.portfolioapp.ui.viewmodel.onboarding

import android.app.Application
import androidx.lifecycle.MutableLiveData
import br.com.portfolioapp.R
import br.com.portfolioapp.domain.usecase.ValidateTextUsecase
import br.com.portfolioapp.ui.viewmodel.BaseViewModel
import org.koin.java.KoinJavaComponent.inject

class RegisterViewModel(app: Application) : BaseViewModel(app) {

    private val validateTextUsecase: ValidateTextUsecase by inject(ValidateTextUsecase::class.java)
    val validationErrorLiveData = MutableLiveData<String?>()

    fun validateField(text: String) {
        if (validateTextUsecase.validateTextEmpty(text)) {
            validationErrorLiveData.value = app.getString(R.string.validation_empty_error)
        } else {
            validationErrorLiveData.value = null
        }
    }

    fun handleButtonEnabled(error: String?) : Boolean {
        return validateTextUsecase.validateTextEmpty(error)
    }
}