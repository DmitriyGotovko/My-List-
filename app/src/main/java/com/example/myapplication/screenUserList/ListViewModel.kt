package com.example.myapplication.screenUserList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.User
import com.example.myapplication.UserRepository

class ListViewModel() : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        _users.value = UserRepository.users
    }

    fun onRemoveAllClicked() {
        UserRepository.removeAll()
        _users.value = UserRepository.users
    }

    fun onRemoveLastClicked() {
        UserRepository.removeLast()
        _users.value = UserRepository.users
    }

    fun onEditSecondClicked() {
        if (UserRepository.users.size < 2) return
        UserRepository.updateUser(1, User("Ivan ", "Ivanov", "Mexico"))
        _users.value = UserRepository.users
    }

    fun onAddRandomClicked() {
        UserRepository.addRandomUser()
        _users.value = UserRepository.users
    }
}

