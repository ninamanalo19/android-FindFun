package com.ninaestoye.findfriends.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ninaestoye.findfriends.R
import com.ninaestoye.findfriends.model.Friend

class FriendsListAdapter: RecyclerView.Adapter<FriendsListAdapter.ViewHolder>() {

    private var friends = emptyList<Friend>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.friend_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return friends.size;
    }

    fun populateFriends(friends: List<Friend>) {
        this.friends = friends;
        notifyDataSetChanged();
    }
}