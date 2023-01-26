package com.ergea.finalapp.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.data.local.datastore.DataStoreManager
import com.ergea.finalapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddDialogViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    fun addNote(noteEntity: NoteEntity) = CoroutineScope(Dispatchers.IO).launch {
        noteRepository.addNote(noteEntity)
    }

    fun getIdUser() = dataStoreManager.getIdUser.asLiveData()

}