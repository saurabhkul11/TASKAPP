package com.example.newtask.storage

import android.widget.TextView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author_table" )
 data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "AUTHOR") var author: String,
    @ColumnInfo(name = "THOUGHTS") var thought:String,
    @ColumnInfo(name = "URL") var url:String,
    @ColumnInfo(name = "TYPE") var type:String
 )



