package com.ergea.finalapp.ui.login

import androidx.lifecycle.ViewModel
import com.ergea.finalapp.data.local.datastore.DataStoreManager
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
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    fun getUserIfExist(email: String, password: String) =
        userRepository.getUserIfExist(email, password)

    fun setId(id: Int) = CoroutineScope(Dispatchers.IO).launch {
        dataStoreManager.setIdUser(id)
    }
}