package com.example.notes.core.server

import com.example.notes.Constants
import com.example.notes.core.entity.NoteModel
import retrofit2.Response
import retrofit2.http.*


interface Ret {

    @GET(Constants.BASE_URL)
    suspend fun get(): Response<NoteModel>

    @POST(Constants.BASE_URL)
    suspend fun create(@Body noteModel: NoteModel): Response<NoteModel>

    @PUT("update/{id}")
    suspend fun update(@Path("id") id: Int, @Body noteModel: NoteModel?): Response<NoteModel?>?

    @DELETE("delete/{id}")
    fun deleteUser(@Path("id") id: Int): Response<NoteModel?>?
}