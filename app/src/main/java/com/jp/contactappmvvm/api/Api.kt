package com.jp.contactappmvvm.api

import com.jp.contactappmvvm.models.ContactModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Jignesh Chauhan on 28-08-2023
 */
interface Api {
    @GET("getContacts.php")
    suspend fun getContacts(): Response<List<ContactModel>>
}