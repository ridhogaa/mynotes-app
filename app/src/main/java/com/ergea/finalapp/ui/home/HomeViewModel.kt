package com.ergea.finalapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.data.local.database.entity.UserEntity
import com.ergea.finalapp.data.local.datastore.DataStoreManager
import com.ergea.finalapp.data.repository.NoteRepository
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
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _user: MutableLiveData<UserEntity> = MutableLiveData()
    val user: LiveData<UserEntity> get() = _user

    private val _notes: MutableLiveData<List<NoteEntity>> = MutableLiveData()
    val notes: LiveData<List<NoteEntity>> get() = _notes

    fun fetchingUser(id_user: Int) = CoroutineScope(Dispatchers.IO).launch {
        _user.postValue(userRepository.getUserById(id_user))
    }

    fun fetchingNotes(id_user: Int) = CoroutineScope(Dispatchers.IO).launch {
        _notes.postValue(noteRepository.getListNotes(id_user))
    }

    fun clear() = CoroutineScope(Dispatchers.IO).launch {
        dataStoreManager.clear()
    }

    fun getIdUser() = dataStoreManager.getIdUser.asLiveData()


}