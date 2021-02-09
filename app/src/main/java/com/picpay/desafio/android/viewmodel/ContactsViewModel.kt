package com.picpay.desafio.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.network.webservice.PicPayService
import com.picpay.desafio.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactsViewModel(
    private val repository: UserRepository
): ViewModel() {

    private val _dataLoadingState = MutableLiveData<DataLoadingState>()

    val loadingState: LiveData<DataLoadingState>
        get() = _dataLoadingState

    val data = repository.getUsers()

    init {
        refreshData()
    }

    private fun refreshData() {
        viewModelScope.launch {
            try {
                _dataLoadingState.value = DataLoadingState.LOADING
                repository.refresh()
                _dataLoadingState.value = DataLoadingState.LOADED
            } catch (e: Exception) {
                _dataLoadingState.value = DataLoadingState.FAILED
            }
        }
    }
}
