package br.com.portfolioapp.data.db

import android.content.Context
import androidx.room.Room

class UserDatabaseManager(context: Context) {
    val userDb = Room.databaseBuilder(context, UserDatabase::class.java, "user-db").build()
}