package br.com.portfolioapp.ui.viewmodel.onboarding

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.portfolioapp.domain.usecase.SaveUserUsecase
import br.com.portfolioapp.domain.usecase.ValidateTextUsecase
import br.com.portfolioapp.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class RegisterViewModel(app: Application) : BaseViewModel(app) {

    private val validateTextUsecase: ValidateTextUsecase by inject(ValidateTextUsecase::class.java)
    private val saveUserUsecase: SaveUserUsecase by inject(SaveUserUsecase::class.java)

    val validationErrorLiveData = MutableLiveData<String?>()

    fun validateField(text: String) {
        validationErrorLiveData.value = validateTextUsecase.getEmptyFieldValidationMessage(text)
    }

    fun handleButtonEnabled(error: String?) : Boolean {
        return validateTextUsecase.validateEmptyText(error)
    }

    fun saveUsername(name: String) {
        viewModelScope.launch {
            saveUserUsecase.saveUser(name)
        }
    }
}