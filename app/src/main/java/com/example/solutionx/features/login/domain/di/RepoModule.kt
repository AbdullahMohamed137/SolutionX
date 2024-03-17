package com.example.solutionx.features.login.domain.di

import com.example.solutionx.features.login.data.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.data.repository.LoginRepositoryImpl
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideRepo(loginWithRemoteDS: ILoginRemoteDS) : ILoginRepository{
        return LoginRepositoryImpl(loginWithRemoteDS)
    }
}