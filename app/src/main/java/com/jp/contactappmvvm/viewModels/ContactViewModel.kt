package com.jp.contactappmvvm.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jp.contactappmvvm.models.ContactModel
import com.jp.contactappmvvm.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Jignesh Chauhan on 01-09-2023
 */

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: ContactRepository) :
    ViewModel() {

    val contacts: StateFlow<List<ContactModel>>
        get() = repository.contacts

    init {

        viewModelScope.launch {
            repository.getContacts()
        }
    }
}