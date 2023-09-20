package com.kdn.data.remote.datasource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\b\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/kdn/data/remote/datasource/RemoteAuthDataSource;", "", "gAuthLogin", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kdn/data/remote/dto/auth/response/GAuthLoginResponse;", "body", "Lcom/kdn/data/remote/dto/auth/request/GAuthLoginRequest;", "(Lcom/kdn/data/remote/dto/auth/request/GAuthLoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lcom/kdn/data/remote/dto/auth/response/RefreshTokenResponse;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"})
public abstract interface RemoteAuthDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object gAuthLogin(@org.jetbrains.annotations.NotNull
    com.kdn.data.remote.dto.auth.request.GAuthLoginRequest body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.kdn.data.remote.dto.auth.response.GAuthLoginResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.kdn.data.remote.dto.auth.response.RefreshTokenResponse>> continuation);
}