package com.example.solutionx.common.di

import com.example.solutionx.common.domain.repository.remoteDS.ILoginRemoteDS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
internal class NetworkModule {
    @Provides
    @ViewModelScoped
    fun provideOkHttp(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)

        return client.build()
    }

    @Provides
    @ViewModelScoped
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dev.api.altashirat.solutionplus.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideILoginRemoteDS(retrofit: Retrofit): ILoginRemoteDS {
        return retrofit.create(ILoginRemoteDS::class.java)
    }
}