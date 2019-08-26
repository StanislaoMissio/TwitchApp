package com.example.projecttwitch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.projecttwitch.model.User

class ProfileViewModel : ViewModel() {

    private val users = MutableLiveData<User>()

    fun setUser(user: User){
        users.value = user
    }

    fun getUsers(): LiveData<User> {
        return users
    }

}