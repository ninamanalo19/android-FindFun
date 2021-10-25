package com.ninaestoye.findfriends.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ninaestoye.findfriends.R
import com.ninaestoye.findfriends.adpater.FriendsListAdapter
import com.ninaestoye.findfriends.databinding.FragmentFriendsListBinding
import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.viewModel.FriendViewModel
import kotlinx.android.synthetic.main.fragment_friends_list.*
import kotlinx.android.synthetic.main.fragment_friends_list.view.*

class FriendsListFragment : Fragment() {

    private val TAG = FriendsListFragment::class.java.simpleName;
    private lateinit var adapter : FriendsListAdapter;
    private lateinit var friendViewModel: FriendViewModel;
    private lateinit var binding : FragmentFriendsListBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friends_list, container, false);
        val view = binding.root;
        friendViewModel = ViewModelProvider(this).get(FriendViewModel::class.java);
        adapter = FriendsListAdapter();

        val recyclerView = view.rvFriends;

        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(requireContext());

        friendViewModel.getAllFriends.observe(viewLifecycleOwner, Observer { friends ->

            adapter.populateFriends(friends);
        });

        fetchFriends();

        return view;
    }

    /*private fun fetchFriend(id: Int) {
        friendViewModel.fetchFriend(id)
        friendViewModel.fetchFriendResponse.observe(viewLifecycleOwner, Observer { response ->
            Log.d(TAG, "fetchFriend() -- response=$response")

            if (response.isSuccessful) {
                Log.d(TAG, "fetchFriend() -- success")
                binding.friend = response.body();
            }
        });
    }*/

    private fun fetchFriends() {
        friendViewModel.fetchFriends();
        friendViewModel.fetchFriendsResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { friends ->
                    adapter.populateFriends(friends);
                }
            }
        })
    }

}