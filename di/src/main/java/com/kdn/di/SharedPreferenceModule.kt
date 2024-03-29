package com.kdn.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferenceModule {
    @Provides
    fun providesSharedPreference(
        @ApplicationContext context: Context,
    ): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}