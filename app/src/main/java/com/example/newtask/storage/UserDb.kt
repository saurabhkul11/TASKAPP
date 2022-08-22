package com.example.newtask.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(UserEntity::class)],version = 2)
abstract class UserDb: RoomDatabase() {

    abstract fun userDao(): UserDao


}