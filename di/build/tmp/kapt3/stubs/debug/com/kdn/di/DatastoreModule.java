package com.kdn.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/kdn/di/DatastoreModule;", "", "()V", "providePreferencesDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "context", "Landroid/content/Context;", "di_debug"})
@dagger.Module
public final class DatastoreModule {
    @org.jetbrains.annotations.NotNull
    public static final com.kdn.di.DatastoreModule INSTANCE = null;
    
    private DatastoreModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> providePreferencesDataStore(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
}