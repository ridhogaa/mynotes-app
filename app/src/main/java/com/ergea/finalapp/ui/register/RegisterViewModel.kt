package com.ergea.finalapp.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ergea.finalapp.data.local.database.entity.UserEntity
import com.ergea.finalapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun registerUser(userEntity: UserEntity) = CoroutineScope(Dispatchers.IO).launch {
        userRepository.registerUser(userEntity)
    }

    fun checkEmailIfExist(email: String) = userRepository.checkEmailIfExist(email)
}