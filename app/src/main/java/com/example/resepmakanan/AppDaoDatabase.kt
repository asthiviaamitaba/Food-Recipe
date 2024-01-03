package com.example.resepmakanan

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class], exportSchema = false, version = 1)
abstract class AppDaoDatabase :RoomDatabase(){
    abstract fun getDao():Dao
}