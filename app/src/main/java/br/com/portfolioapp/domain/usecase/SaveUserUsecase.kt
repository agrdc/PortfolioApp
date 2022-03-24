package br.com.portfolioapp.domain.usecase

import br.com.portfolioapp.data.repository.UserRepository


class SaveUserUsecase(private val repository: UserRepository) {

    suspend fun saveUser(name: String) {
        repository.saveUser(name)
    }
}