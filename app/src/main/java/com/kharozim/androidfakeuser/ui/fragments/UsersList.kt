package com.kharozim.androidfakeuser.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.kharozim.androidfakeuser.R
import com.kharozim.androidfakeuser.adapters.UserAdapter
import com.kharozim.androidfakeuser.clients.UserClient
import com.kharozim.androidfakeuser.databinding.ActivityMainBinding
import com.kharozim.androidfakeuser.databinding.FragmentUsersListBinding
import com.kharozim.androidfakeuser.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersList : Fragment(), UserAdapter.UserListener {
    private lateinit var binding: FragmentUsersListBinding
    private val adapter by lazy { UserAdapter(requireContext(), this) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersListBinding.inflate(inflater, container, false).apply {
            rvMain.adapter = adapter
            btCreate.setOnClickListener { findNavController().navigate(R.id.action_usersList_to_userList) }

        }
        UserClient.service.getAllUser().enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                response.body()?.let {
                    adapter.setData(it.data)
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                onError(t)
            }

        })

        return binding.root
    }

//    private fun toUserLayout(id: Int) {
//
//    }

    private fun onError(t: Throwable) {
        t.printStackTrace()
        Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
    }

    override fun onSelect(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onDelete(id: Int) {
        UserClient.service.getDeleteByID(id).enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    adapter.deleteUserById(id)
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                onError(t)
            }

        })
    }


}