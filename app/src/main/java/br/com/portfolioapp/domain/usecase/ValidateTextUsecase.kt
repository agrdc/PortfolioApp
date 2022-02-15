package br.com.portfolioapp.domain.usecase

class ValidateTextUsecase {
    fun validateTextEmpty(text: String?) : Boolean {
        return text.isNullOrEmpty()
    }
}