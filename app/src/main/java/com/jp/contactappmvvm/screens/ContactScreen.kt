package com.jp.contactappmvvm.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jp.contactappmvvm.models.ContactModel
import com.jp.contactappmvvm.viewModels.ContactViewModel

/**
 * Created by Jignesh Chauhan on 01-09-2023
 */
@Composable
fun ContactScreen() {

    val contactViewModel: ContactViewModel = viewModel()
    val contacts: State<List<ContactModel>> = contactViewModel.contacts.collectAsState()

    LazyColumn(content = {
        items(contacts.value){
            ContactItem(contactModel = it)
        }
    })

}