package com.example.android.samplemvvmproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.samplemvvmproject.data.network.response.Results
import com.example.android.samplemvvmproject.ui.adapters.UserListAdapter
import com.example.android.samplemvvmproject.ui.viewmodel.UserViewModel
import com.example.android.samplemvvmproject.ui.viewmodel.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: UserViewModelFactory by instance()
    lateinit var viewModel: UserViewModel
    lateinit var userListAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelSetUp()
        userListAdapter = UserListAdapter()

        //Observe User LiveData
        viewModel.downloadedUsers.observe(this, Observer {
            Log.d("Check User Response", it.toString())
            val list: MutableList<Results> = it.results as MutableList<Results>
            userListAdapter.submitList(list)
            rv_users.adapter = userListAdapter
        })

        GlobalScope.launch(Dispatchers.Main) {
            viewModel.fetchCurrentUsers(10)
        }
    }

    private fun viewModelSetUp() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(UserViewModel::class.java)
    }
}
