package com.jp.contactappmvvm.repository

import com.jp.contactappmvvm.api.Api
import com.jp.contactappmvvm.models.ContactModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Created by Jignesh Chauhan on 01-09-2023
 */
class ContactRepository @Inject constructor(private val api: Api) {

    private var _contacts = MutableStateFlow<List<ContactModel>>(emptyList())
    val contacts: StateFlow<List<ContactModel>> get() = _contacts
    suspend fun getContacts() {
        val response = api.getContacts()
        if (response.isSuccessful && response.body() != null) {
            response.body().let {
                if (it != null) {
                    _contacts.emit(it)
                }
            }
        }

    }
}