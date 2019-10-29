package com.example.android.samplemvvmproject.data.network

import androidx.lifecycle.LiveData
import com.example.android.samplemvvmproject.data.network.response.UserResultsResponse

interface UserNetworkDataSource {
    val downloadedUsers: LiveData<UserResultsResponse>
    suspend fun fetchCurrentUsers(number: Int)
}