package com.kdn.data.remote.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/kdn/data/remote/api/AuthAPI;", "", "gAuthLogin", "Lcom/kdn/data/remote/dto/auth/response/GAuthLoginResponse;", "body", "Lcom/kdn/data/remote/dto/auth/request/GAuthLoginRequest;", "(Lcom/kdn/data/remote/dto/auth/request/GAuthLoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideAccessToken", "Lcom/kdn/data/remote/dto/auth/response/RefreshTokenResponse;", "refreshToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface AuthAPI {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/auth")
    public abstract java.lang.Object gAuthLogin(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.kdn.data.remote.dto.auth.request.GAuthLoginRequest body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.kdn.data.remote.dto.auth.response.GAuthLoginResponse> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.PATCH(value = "/auth")
    public abstract java.lang.Object provideAccessToken(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Header(value = "refreshToken")
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.kdn.data.remote.dto.auth.response.RefreshTokenResponse> continuation);
}