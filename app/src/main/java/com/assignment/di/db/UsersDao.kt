package com.assignment.di.db

import androidx.room.*
import com.assignment.di.entity.UsersEntity

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertUser(usersEntity: UsersEntity)

    @Delete
     fun deleteUser(usersEntity: UsersEntity)

    @Update
     fun update(usersEntity: UsersEntity)

    @Query("SELECT * FROM Users_table ORDER BY id ASC")
    fun getAllUsers(): List<UsersEntity>
}