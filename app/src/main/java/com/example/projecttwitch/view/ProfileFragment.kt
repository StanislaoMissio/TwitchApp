package com.example.projecttwitch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projecttwitch.R
import com.example.projecttwitch.model.User
import com.example.projecttwitch.viewmodel.ProfileViewModel
import java.lang.Exception

class ProfileFragment : Fragment() {

    lateinit var model: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this)[ProfileViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        model.getUsers().observe(this, Observer<User> { user ->

        })
    }

}