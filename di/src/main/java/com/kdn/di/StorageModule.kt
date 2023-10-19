package com.kdn.di

import com.kdn.data.local.auth.datastorage.AuthPreference
import com.kdn.data.local.auth.datastorage.AuthPreferenceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun provideAuthDataStorage(
        authDataStorageImpl: AuthPreferenceImpl
    ): AuthPreference
}