package com.ergea.finalapp.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ergea.finalapp.data.local.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    fun getIdUser() = dataStoreManager.getIdUser.asLiveData()
}