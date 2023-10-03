package com.kdn.di

import com.kdn.data.repository.auth.*
import com.kdn.data.repository.goods.GoodsRepositoryImpl
import com.kdn.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl,
    ): AuthRepository

    @Singleton
    @Binds
    abstract fun provideGoodsRepository(
        goodsRepositoryImpl: GoodsRepositoryImpl,
    ): GoodsRepository
}