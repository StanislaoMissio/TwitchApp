package com.example.projecttwitch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projecttwitch.model.User

class ProfileViewModel : ViewModel() {

    var users = MutableLiveData<User>()

}