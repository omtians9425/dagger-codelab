package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.data.DogService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import javax.inject.Singleton
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.create

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()

    @Singleton
    @Provides
    fun provideDogService(retrofit: Retrofit) : DogService = retrofit.create()
}