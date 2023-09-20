package com.kdn.di

import com.kdn.data.local.datasource.LocalAuthDataSource
import com.kdn.data.local.datasource.LocalAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun provideLocalAuthDataSource(
        localAuthDataSourceImpl: LocalAuthDataSourceImpl,
    ): LocalAuthDataSource

}