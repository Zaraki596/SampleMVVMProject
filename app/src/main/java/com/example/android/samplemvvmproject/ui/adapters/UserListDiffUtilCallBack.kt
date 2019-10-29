package com.example.android.samplemvvmproject.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.android.samplemvvmproject.data.network.response.Results

class UserListDiffUtilCallBack : DiffUtil.ItemCallback<Results>(){
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.name.first == newItem.name.first
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.name.first == newItem.name.first
    }

}