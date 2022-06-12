package com.example.notes.core.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.notes.core.server.NetworkResult
import com.example.notes.core.entity.NoteModel
import com.example.notes.core.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor
    (
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {
    private val _response: MutableLiveData<NetworkResult<NoteModel>> = MutableLiveData()
    val response: LiveData<NetworkResult<NoteModel>> = _response
    fun fetchResponse() = viewModelScope.launch {
        repository.get().collect { values -> _response.value = values }
    }
//        fun createResponse() = viewModelScope.launch {
//            repository.create().collect { values -> _response.value = values }
//        }
//            fun updateResponse() = viewModelScope.launch {
//                repository.update().collect { values -> _response.value = values }
//            }
//                fun deleteResponse() = viewModelScope.launch {
//                    repository.delete().collect { values -> _response.value = values }
//                }
            }