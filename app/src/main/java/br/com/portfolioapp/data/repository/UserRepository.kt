package br.com.portfolioapp.data.repository

import br.com.portfolioapp.data.datasource.UserLocalDataSource
import br.com.portfolioapp.data.model.User

class UserRepository(private val userLocalDataSource: UserLocalDataSource) {
    suspend fun saveUser(name: String) {
        userLocalDataSource.saveUser(User(firstName = name))
    }
}