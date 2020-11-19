package com.kharozim.androidfakeuser.ui.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kharozim.androidfakeuser.R
import com.kharozim.androidfakeuser.adapters.UserAdapter
import com.kharozim.androidfakeuser.clients.UserClient
import com.kharozim.androidfakeuser.databinding.ActivityMainBinding
import com.kharozim.androidfakeuser.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}