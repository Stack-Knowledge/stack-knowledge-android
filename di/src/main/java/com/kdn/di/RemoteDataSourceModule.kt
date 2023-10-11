package com.kdn.di

import com.kdn.data.remote.datasource.auth.RemoteAuthDataSource
import com.kdn.data.remote.datasource.auth.RemoteAuthDataSourceImpl
import com.kdn.data.remote.datasource.item.RemoteItemDataSource
import com.kdn.data.remote.datasource.item.RemoteItemDataSourceImpl
import com.kdn.data.remote.datasource.order.RemoteOrderDataSource
import com.kdn.data.remote.datasource.order.RemoteOrderDataSourceImpl
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

    @Binds
    abstract fun provideRemoteItemDataSource(
        remoteItemDataSourceImpl: RemoteItemDataSourceImpl,
    ): RemoteItemDataSource

    @Binds
    abstract fun provideRemoteOrderDataSource(
        remoteOrderDataSourceImpl: RemoteOrderDataSourceImpl,
    ): RemoteOrderDataSource
}