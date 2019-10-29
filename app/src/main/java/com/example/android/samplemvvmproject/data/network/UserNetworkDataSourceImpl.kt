package com.example.android.samplemvvmproject.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.samplemvvmproject.data.network.response.Results
import com.example.android.samplemvvmproject.data.network.response.UserResultsResponse
import com.example.android.samplemvvmproject.internal.NoConnectivityExcpetion
import javax.xml.transform.Templates

class UserNetworkDataSourceImpl(
    private val apiService: ApiService
) : UserNetworkDataSource {
    val _downloadedUsers = MutableLiveData<UserResultsResponse>()
    override val downloadedUsers: LiveData<UserResultsResponse>
        get() = _downloadedUsers

    override suspend fun fetchCurrentUsers(number: Int) {
        try {
            val fetchCurrentUsers = apiService.getUsers(10)
            _downloadedUsers.postValue(fetchCurrentUsers)
        }
        catch (e : NoConnectivityExcpetion){
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}