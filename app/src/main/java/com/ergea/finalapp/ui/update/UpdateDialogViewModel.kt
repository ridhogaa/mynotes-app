package com.ergea.finalapp.ui.update

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
class UpdateDialogViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    fun updateNote(title: String, desc: String, id_note: Int, id_user: Int) =
        CoroutineScope(Dispatchers.IO).launch {
            noteRepository.updateNote(title, desc, id_note, id_user)
        }

    fun getIdUser() = dataStoreManager.getIdUser.asLiveData()

}