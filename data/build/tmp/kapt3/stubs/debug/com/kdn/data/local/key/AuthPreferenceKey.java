package com.kdn.data.local.key;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/kdn/data/local/key/AuthPreferenceKey;", "", "()V", "ACCESS_TOKEN", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getACCESS_TOKEN", "()Landroidx/datastore/preferences/core/Preferences$Key;", "AUTHORITY", "getAUTHORITY", "EXPIRE_AT", "getEXPIRE_AT", "REFRESH_TOKEN", "getREFRESH_TOKEN", "data_debug"})
public final class AuthPreferenceKey {
    @org.jetbrains.annotations.NotNull
    public static final com.kdn.data.local.key.AuthPreferenceKey INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> ACCESS_TOKEN = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> REFRESH_TOKEN = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> EXPIRE_AT = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> AUTHORITY = null;
    
    private AuthPreferenceKey() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getACCESS_TOKEN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getREFRESH_TOKEN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getEXPIRE_AT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getAUTHORITY() {
        return null;
    }
}