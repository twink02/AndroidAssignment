package com.assignment.di.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assignment.di.entity.UsersEntity

@Database(entities = [UsersEntity::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun dao():UsersDao
}