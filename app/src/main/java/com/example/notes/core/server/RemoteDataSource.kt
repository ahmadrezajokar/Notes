package com.example.notes.core.server

import com.example.notes.core.entity.NoteModel
import com.example.notes.core.server.Ret
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val ret: Ret) {
    suspend fun get() =
        ret.get()
//    suspend fun create() =
//        ret.create()
//
//    suspend fun update() =
//        ret.update()
//
//    suspend fun delete() =
//        ret.deleteUser()
}
