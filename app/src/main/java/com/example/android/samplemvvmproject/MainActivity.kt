package com.example.android.samplemvvmproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.samplemvvmproject.data.network.ApiService
import com.example.android.samplemvvmproject.data.network.ConnectivityInterceptorImpl
import com.example.android.samplemvvmproject.data.network.UserNetworkDataSourceImpl
import com.example.android.samplemvvmproject.data.network.response.Results
import com.example.android.samplemvvmproject.ui.adapters.UserListAdapter
import com.example.android.samplemvvmproject.ui.viewmodel.UserViewModel
import com.google.gson.Gson
import com.google.gson.internal.GsonBuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var userListAdapter: UserListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userListAdapter = UserListAdapter()

        val apiService = ApiService.invoke(ConnectivityInterceptorImpl(this))
        val userNetworkDataSource = UserNetworkDataSourceImpl(apiService)


        userNetworkDataSource.downloadedUsers.observe(this, Observer {
            Log.d("Check User Response", it.toString())
            val list : MutableList<Results> = it.results as MutableList<Results>
             userListAdapter.submitList(list)
            rv_users.adapter = userListAdapter
        })

        GlobalScope.launch(Dispatchers.Main) {
            userNetworkDataSource.fetchCurrentUsers(10)

        }
    }
}
