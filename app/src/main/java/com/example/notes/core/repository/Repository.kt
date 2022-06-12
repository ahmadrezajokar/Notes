package com.example.notes.core.repository

import com.example.notes.core.entity.NoteModel
import com.example.notes.core.server.NetworkResult
import com.example.notes.core.server.RemoteDataSource
import com.example.notes.core.server.BaseApiResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource) : BaseApiResponse() {
    suspend fun get(): Flow<NetworkResult<NoteModel>> {
        return flow<NetworkResult<NoteModel>> { emit(safeApiCall { remoteDataSource.get() }) }.flowOn(Dispatchers.IO)
    }

//    suspend fun create(): Flow<NetworkResult<NoteModel>> {
//        return flow<NetworkResult<NoteModel>> { emit(safeApiCall { remoteDataSource.create() }) }.flowOn(Dispatchers.IO)
//    }
//
//    suspend fun update(): Flow<NetworkResult<NoteModel>> {
//        return flow<NetworkResult<NoteModel>> { emit(safeApiCall { remoteDataSource.update() }) }.flowOn(Dispatchers.IO)
//    }
//
//    suspend fun delete(): Flow<NetworkResult<NoteModel>> {
//        return flow<NetworkResult<NoteModel>> { emit(safeApiCall { remoteDataSource.delete() }) }.flowOn(Dispatchers.IO)
//    }
}





