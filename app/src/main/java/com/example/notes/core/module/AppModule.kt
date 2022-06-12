package com.example.notes.core.module

import com.example.notes.Base
import com.example.notes.Constants.Companion.BASE_URL
import com.example.notes.core.entity.NoteModel
import com.example.notes.core.server.Ret
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory).build()
    }

    @Singleton
    @Provides
    fun provideCurrencyService(retrofit: Retrofit): NoteModel =
        retrofit.create(NoteModel::class.java)

    @Singleton
    @Provides
    fun provideRetService(retrofit: Retrofit): Ret =
        retrofit.create(Ret::class.java)

    @Singleton
    fun base():Base{
        var base:Base = Base()
        return base
    }
}