package br.com.portfolioapp.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.portfolioapp.data.model.User

interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}