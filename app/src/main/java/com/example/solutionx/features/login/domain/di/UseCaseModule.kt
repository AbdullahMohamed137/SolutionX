package com.example.solutionx.features.login.domain.di

import com.example.solutionx.features.login.data.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.data.remoteDS.LoginRemoteDsImpl
import com.example.solutionx.features.login.data.repository.LoginRepositoryImpl
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import com.example.solutionx.features.login.domain.useCases.LoginWithEmailUC
import com.example.solutionx.features.login.domain.useCases.LoginWithPhoneUC
import com.example.solutionx.features.login.domain.useCases.LoginWithSocialUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideRepo(loginWithRemoteDS: ILoginRemoteDS) : ILoginRepository {
        return LoginRepositoryImpl(loginWithRemoteDS)
    }

    @Provides
    @Singleton
    fun provideLoginRemoteDS() : ILoginRemoteDS {
        return LoginRemoteDsImpl()
    }

    @Provides
    @Singleton
    fun provideUseCaseEmail(loginRepo: ILoginRepository): LoginWithEmailUC {
        return LoginWithEmailUC(loginRepo)
    }

    @Provides
    @Singleton
    fun provideUseCasePhone(loginRepo: ILoginRepository): LoginWithPhoneUC {
        return LoginWithPhoneUC(loginRepo)
    }

    @Provides
    @Singleton
    fun provideUseCaseSocial(loginRepo: ILoginRepository): LoginWithSocialUC {
        return LoginWithSocialUC(loginRepo)
    }

}