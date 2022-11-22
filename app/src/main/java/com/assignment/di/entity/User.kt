package com.assignment.di.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users_table")
data class UsersEntity(
    @PrimaryKey()
    val id: Long,
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?,
)