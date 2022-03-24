package br.com.portfolioapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.portfolioapp.data.dao.UserDao
import br.com.portfolioapp.data.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}