package com.ergea.finalapp.ui.delete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ergea.finalapp.data.local.datastore.DataStoreManager
import com.ergea.finalapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteDialogViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    fun deleteNote(id_note: Int, id_user: Int) = CoroutineScope(Dispatchers.IO).launch {
        noteRepository.deleteNote(id_note, id_user)
    }

    fun getIdUser() = dataStoreManager.getIdUser.asLiveData()
}