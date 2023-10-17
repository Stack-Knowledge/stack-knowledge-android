package com.kdn.di

import com.kdn.data.local.auth.datastorage.AuthDataStorage
import com.kdn.data.local.auth.datastorage.AuthDataStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun provideAuthDataStorage(
        authDataStorageImpl: AuthDataStorageImpl
    ): AuthDataStorage
}