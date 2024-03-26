package com.example.solutionx.common.di

import com.example.solutionx.common.domain.repository.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.data.repository.LoginRepositoryImpl
import com.example.solutionx.common.data.repository.localDS.LoginLocalDSImpl
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import com.example.solutionx.common.domain.repository.localDS.ILoginLocalDS
import com.example.solutionx.features.login.domain.useCases.LoginWithEmailUC
import com.example.solutionx.features.login.domain.useCases.LoginWithPhoneUC
import com.example.solutionx.features.login.domain.useCases.LoginWithSocialUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlin.coroutines.coroutineContext

@Module
@InstallIn(ViewModelComponent::class)
internal class DiModule {

    @Provides
    @ViewModelScoped
    fun provideRepo(
        loginWithRemoteDS: ILoginRemoteDS,
        loginLocalDS: ILoginLocalDS
    ): ILoginRepository {
        return LoginRepositoryImpl(loginWithRemoteDS, loginLocalDS)
    }

//    @Provides
//    @ViewModelScoped
//    fun provideLoginRemoteDS(): ILoginRemoteDS {
//        return LoginRemoteDsImpl()
//    }

    @Provides
    @ViewModelScoped
    fun provideLoginLocalDS(): ILoginLocalDS {
        return LoginLocalDSImpl()
    }

    @Provides
    @ViewModelScoped
    fun provideUseCaseEmail(loginRepo: ILoginRepository): LoginWithEmailUC {
        return LoginWithEmailUC(loginRepo)
    }

    @Provides
    @ViewModelScoped
    fun provideUseCasePhone(loginRepo: ILoginRepository): LoginWithPhoneUC {
        return LoginWithPhoneUC(loginRepo)
    }

    @Provides
    @ViewModelScoped
    fun provideUseCaseSocial(loginRepo: ILoginRepository): LoginWithSocialUC {
        return LoginWithSocialUC(loginRepo)
    }

}