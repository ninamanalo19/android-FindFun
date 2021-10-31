package com.ninaestoye.findfriends.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ninaestoye.findfriends.R
import com.ninaestoye.findfriends.databinding.FriendRowBinding
import com.ninaestoye.findfriends.model.Friend

class FriendsListAdapter: RecyclerView.Adapter<FriendsListAdapter.ViewHolder>() {

    private var friends = emptyList<Friend>()

    class ViewHolder(val binding: FriendRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.friend_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.friend = friends[position];
    }

    override fun getItemCount(): Int {
        return friends.size;
    }

    fun populateFriends(friends: List<Friend>) {
        this.friends = friends;
        notifyDataSetChanged();
    }
}