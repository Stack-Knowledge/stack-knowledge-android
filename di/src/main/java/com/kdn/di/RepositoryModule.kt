package com.kdn.di

import com.kdn.data.repository.auth.*
import com.kdn.data.repository.item.ItemRepositoryImpl
import com.kdn.data.repository.mission.MissionRepositoryImpl
import com.kdn.data.repository.order.OrderRepositoryImpl
import com.kdn.data.repository.solve.SolveRepositoryImpl
import com.kdn.data.repository.student.StudentRepositoryImpl
import com.kdn.domain.repository.*
import com.kdn.domain.repository.auth.AuthRepository
import com.kdn.domain.repository.item.ItemRepository
import com.kdn.domain.repository.mission.MissionRepository
import com.kdn.domain.repository.order.OrderRepository
import com.kdn.domain.repository.solve.SolveRepository
import com.kdn.domain.repository.student.StudentRepository
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
    abstract fun provideItemRepository(
        itemRepositoryImpl: ItemRepositoryImpl,
    ): ItemRepository

    @Singleton
    @Binds
    abstract fun provideOrderRepository(
        orderRepositoryImpl: OrderRepositoryImpl,
    ): OrderRepository

    @Singleton
    @Binds
    abstract fun provideMissionRepository(
        missionRepositoryImpl: MissionRepositoryImpl,
    ): MissionRepository

    @Singleton
    @Binds
    abstract fun provideSolveRepository(
        solveRepositoryImpl: SolveRepositoryImpl,
    ): SolveRepository

    @Singleton
    @Binds
    abstract fun provideStudentRepository(
        studentRepositoryImpl: StudentRepositoryImpl,
    ): StudentRepository
}