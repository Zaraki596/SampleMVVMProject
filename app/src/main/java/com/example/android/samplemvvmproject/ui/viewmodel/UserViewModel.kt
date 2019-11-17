package com.example.android.samplemvvmproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.samplemvvmproject.data.network.ApiService
import com.example.android.samplemvvmproject.data.network.response.UserResultsResponse
import com.example.android.samplemvvmproject.internal.NoConnectivityExcpetion

class UserViewModel(
    private val apiService: ApiService
) : ViewModel() {

    val _downloadedUsers = MutableLiveData<UserResultsResponse>()
    val downloadedUsers: LiveData<UserResultsResponse>
        get() = _downloadedUsers

    suspend fun fetchCurrentUsers(number: Int) {
        try {
            val fetchCurrentUsers = apiService.getUsers(10)
            _downloadedUsers.postValue(fetchCurrentUsers)
        } catch (e: NoConnectivityExcpetion) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}
