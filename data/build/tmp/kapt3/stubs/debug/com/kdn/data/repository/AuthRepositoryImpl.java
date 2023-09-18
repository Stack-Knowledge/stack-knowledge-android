package com.kdn.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/kdn/data/repository/AuthRepositoryImpl;", "Lcom/kdn/domain/repository/AuthRepository;", "remoteDataSource", "Lcom/kdn/data/remote/datasource/RemoteAuthDataSource;", "localDataSource", "Lcom/kdn/data/local/datasource/LocalAuthDataSource;", "(Lcom/kdn/data/remote/datasource/RemoteAuthDataSource;Lcom/kdn/data/local/datasource/LocalAuthDataSource;)V", "deleteLoginData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gAuthLogin", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kdn/domain/model/response/GAuthLoginResponseModel;", "body", "Lcom/kdn/domain/model/request/GAuthLoginRequestModel;", "(Lcom/kdn/domain/model/request/GAuthLoginRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthorityInfo", "", "provideRefreshToken", "Lcom/kdn/domain/model/response/RefreshTokenResponseModel;", "refreshToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTheLoginData", "data", "(Lcom/kdn/domain/model/response/GAuthLoginResponseModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class AuthRepositoryImpl implements com.kdn.domain.repository.AuthRepository {
    private final com.kdn.data.remote.datasource.RemoteAuthDataSource remoteDataSource = null;
    private final com.kdn.data.local.datasource.LocalAuthDataSource localDataSource = null;
    
    @javax.inject.Inject
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.kdn.data.remote.datasource.RemoteAuthDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.kdn.data.local.datasource.LocalAuthDataSource localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object gAuthLogin(@org.jetbrains.annotations.NotNull
    com.kdn.domain.model.request.GAuthLoginRequestModel body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.kdn.domain.model.response.GAuthLoginResponseModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object saveTheLoginData(@org.jetbrains.annotations.NotNull
    com.kdn.domain.model.response.GAuthLoginResponseModel data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object provideRefreshToken(@org.jetbrains.annotations.NotNull
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.kdn.domain.model.response.RefreshTokenResponseModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getAuthorityInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.String>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object deleteLoginData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}