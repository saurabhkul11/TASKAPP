package com.example.newtask.storage
import androidx.room.Dao
import androidx.room.Query
@Dao
interface UserDao {

    @Query("select * From  author_table")
    abstract fun getData(): List<UserEntity>



}