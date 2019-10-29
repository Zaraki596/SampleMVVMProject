package com.example.android.samplemvvmproject.data.repository

import androidx.lifecycle.LiveData
import com.example.android.samplemvvmproject.data.network.response.UserResultsResponse

interface UsersRepository {
    suspend fun getUser(number : Int) : LiveData<UserResultsResponse>
}