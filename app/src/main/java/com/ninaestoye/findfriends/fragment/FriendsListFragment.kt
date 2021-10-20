package com.ninaestoye.findfriends.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ninaestoye.findfriends.R
import com.ninaestoye.findfriends.adpater.FriendsListAdapter
import com.ninaestoye.findfriends.viewModel.FriendViewModel
import kotlinx.android.synthetic.main.fragment_friends_list.*

class FriendsListFragment : Fragment() {

    private lateinit var adapter : FriendsListAdapter;
    private lateinit var friendViewModel: FriendViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        friendViewModel = ViewModelProvider(this).get(FriendViewModel::class.java);

        adapter = FriendsListAdapter();
        rvFriends.adapter = adapter;
        rvFriends.layoutManager = LinearLayoutManager(requireContext());

        friendViewModel.getAllFriends.observe(viewLifecycleOwner, Observer { friends ->
            adapter.populateFriends(friends);
        });

        return inflater.inflate(R.layout.fragment_friends_list, container, false)
    }

}