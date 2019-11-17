package com.example.android.samplemvvmproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.samplemvvmproject.data.network.ApiService

class UserViewModelFactory(private val apiService: ApiService) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(apiService) as T
    }
}