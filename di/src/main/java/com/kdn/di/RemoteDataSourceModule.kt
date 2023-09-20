package com.kdn.di

import com.kdn.data.remote.datasource.RemoteAuthDataSource
import com.kdn.data.remote.datasource.RemoteAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideRemoteAuthDataSource(
        remoteAuthDataSourceImpl: RemoteAuthDataSourceImpl,
    ): RemoteAuthDataSource
}