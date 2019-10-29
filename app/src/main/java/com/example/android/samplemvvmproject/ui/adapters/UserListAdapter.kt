package com.example.android.samplemvvmproject.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.samplemvvmproject.R
import com.example.android.samplemvvmproject.data.network.response.Results
import com.example.android.samplemvvmproject.databinding.RowUserListItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserListAdapter :
    androidx.recyclerview.widget.ListAdapter<Results, UserListAdapter.UserListViewHolder>(
        UserListDiffUtilCallBack()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RowUserListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.row_user_list_item, parent, false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        getItem(position).let { results ->
            holder.binding.tvUserGender.text = results.gender
            holder.binding.tvUserName.text =
                "${results.name.first} ${results.name.first} ${results.name.last}"
            holder.binding.tvUsersAge.text = results.dob.age.toString() + " yrs"
            holder.binding.tvUserLocation.text =
                "${results.location.city} ${results.location.country}"

            Picasso.get().load(results.picture.thumbnail)
                .error(R.drawable.ic_error_img)
                .into(holder.binding.cvUserImage, object : Callback {
                    override fun onSuccess() {
                        Picasso.get().load(results.picture.large)
                            .into(holder.binding.cvUserImage)
                    }

                    override fun onError(e: Exception?) {
                        Log.e("Error Loading Image", "Error message $e")
                    }

                })

            holder.binding.cvAccept.setOnClickListener {
            }
            holder.binding.cvDecline.setOnClickListener {

            }
        }
    }

    // Action Listener for the Accept and decline of the cards
    interface OnActionClickLstener {

        fun onDeclineClick(position: Int, cvRowItem: View)

        fun onAcceptClick(position: Int, v: View)
    }

    class UserListViewHolder constructor(val binding: RowUserListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
