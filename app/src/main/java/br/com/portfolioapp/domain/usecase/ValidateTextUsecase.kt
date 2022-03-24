package br.com.portfolioapp.domain.usecase

class ValidateTextUsecase(private val emptyFieldErrorMessage: String) {

    fun getEmptyFieldValidationMessage(text: String?) : String? {
        return if (validateEmptyText(text)) {
            emptyFieldErrorMessage
        } else null
    }

    fun validateEmptyText(text: String?): Boolean {
        return text.isNullOrEmpty()
    }
}