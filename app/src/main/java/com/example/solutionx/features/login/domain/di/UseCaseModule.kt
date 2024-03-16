package com.example.solutionx.features.login.domain.di

import com.example.solutionx.features.login.domain.repository.ILoginRepository
import com.example.solutionx.features.login.domain.useCases.LoginWithEmailUC
import com.example.solutionx.features.login.domain.useCases.LoginWithPhoneUC
import com.example.solutionx.features.login.domain.useCases.LoginWithSocialUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCaseEmail(loginRepo: ILoginRepository) : LoginWithEmailUC{
        return LoginWithEmailUC(loginRepo)
    }

    @Provides
    fun provideUseCasePhone(loginRepo: ILoginRepository): LoginWithPhoneUC{
        return LoginWithPhoneUC(loginRepo)
    }

    @Provides
    fun provideUseCaseSocial(loginRepo: ILoginRepository): LoginWithSocialUC{
        return LoginWithSocialUC(loginRepo)
    }
}