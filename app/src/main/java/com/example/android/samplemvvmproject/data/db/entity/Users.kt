package com.example.android.samplemvvmproject.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Users(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val gender: String? = "",
    val title: String? = "",
    val first: String? = "",
    val last: String? = "",
    val city: String? = "",
    val country: String? = "",
    val age: Int? = null,
    val largeImage: String? = "",
    val thumbnail: String? = "",
    val isAccepted: Int = 0
)