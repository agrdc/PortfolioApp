package br.com.portfolioapp.data.datasource

import br.com.portfolioapp.data.db.UserDatabaseManager
import br.com.portfolioapp.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserLocalDataSource(private val userDatabaseManager: UserDatabaseManager) {
    suspend fun saveUser(user: User) {
        withContext(Dispatchers.IO) {
            userDatabaseManager.userDb.userDao().insertAll(user)
        }
    }
}