package com.example.android.samplemvvmproject.data.repository

import androidx.lifecycle.LiveData
import com.example.android.samplemvvmproject.data.network.response.UserResultsResponse

class UsersRepositoryImpl :
    UsersRepository {
    override suspend fun getUser(number: Int): LiveData<UserResultsResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}