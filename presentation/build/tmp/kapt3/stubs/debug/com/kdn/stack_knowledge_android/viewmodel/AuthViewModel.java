package com.kdn.stack_knowledge_android.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0011J\u0006\u0010&\u001a\u00020#J\u000e\u0010\'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u000eR\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\u00178F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0019\u00a8\u0006)"}, d2 = {"Lcom/kdn/stack_knowledge_android/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "gAuthLoginUseCase", "Lcom/kdn/domain/usecase/auth/GAuthLoginUseCase;", "saveTheLoginDataUseCase", "Lcom/kdn/domain/usecase/auth/SaveTheLoginDataUseCase;", "getAuthorityInfoUseCase", "Lcom/kdn/domain/usecase/auth/GetAuthorityInfoUseCase;", "deleteTokenUseCase", "Lcom/kdn/domain/usecase/auth/DeleteTokenUseCase;", "(Lcom/kdn/domain/usecase/auth/GAuthLoginUseCase;Lcom/kdn/domain/usecase/auth/SaveTheLoginDataUseCase;Lcom/kdn/domain/usecase/auth/GetAuthorityInfoUseCase;Lcom/kdn/domain/usecase/auth/DeleteTokenUseCase;)V", "_gAuthLoginRequest", "Landroidx/lifecycle/MutableLiveData;", "Lcom/kdn/stack_knowledge_android/utils/Event;", "Lcom/kdn/domain/model/response/GAuthLoginResponseModel;", "_getAuthorityResponse", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_saveAuthorityResponse", "", "_saveTokenRequest", "", "gAuthLoginRequest", "Landroidx/lifecycle/LiveData;", "getGAuthLoginRequest", "()Landroidx/lifecycle/LiveData;", "getAuthorityResponse", "Lkotlinx/coroutines/flow/StateFlow;", "getGetAuthorityResponse", "()Lkotlinx/coroutines/flow/StateFlow;", "saveAuthorityResponse", "getSaveAuthorityResponse", "saveTokenRequest", "getSaveTokenRequest", "deleteToken", "Lkotlinx/coroutines/Job;", "gAuthLogin", "code", "getAuthorityInfo", "saveTheLoginData", "data", "presentation_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    private final com.kdn.domain.usecase.auth.GAuthLoginUseCase gAuthLoginUseCase = null;
    private final com.kdn.domain.usecase.auth.SaveTheLoginDataUseCase saveTheLoginDataUseCase = null;
    private final com.kdn.domain.usecase.auth.GetAuthorityInfoUseCase getAuthorityInfoUseCase = null;
    private final com.kdn.domain.usecase.auth.DeleteTokenUseCase deleteTokenUseCase = null;
    private final androidx.lifecycle.MutableLiveData<com.kdn.stack_knowledge_android.utils.Event<com.kdn.domain.model.response.GAuthLoginResponseModel>> _gAuthLoginRequest = null;
    private final androidx.lifecycle.MutableLiveData<com.kdn.stack_knowledge_android.utils.Event> _saveTokenRequest = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.kdn.stack_knowledge_android.utils.Event<kotlin.Unit>> _saveAuthorityResponse = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.kdn.stack_knowledge_android.utils.Event<kotlin.Unit>> saveAuthorityResponse = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.kdn.stack_knowledge_android.utils.Event<java.lang.String>> _getAuthorityResponse = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.kdn.stack_knowledge_android.utils.Event<java.lang.String>> getAuthorityResponse = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.kdn.domain.usecase.auth.GAuthLoginUseCase gAuthLoginUseCase, @org.jetbrains.annotations.NotNull
    com.kdn.domain.usecase.auth.SaveTheLoginDataUseCase saveTheLoginDataUseCase, @org.jetbrains.annotations.NotNull
    com.kdn.domain.usecase.auth.GetAuthorityInfoUseCase getAuthorityInfoUseCase, @org.jetbrains.annotations.NotNull
    com.kdn.domain.usecase.auth.DeleteTokenUseCase deleteTokenUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.kdn.stack_knowledge_android.utils.Event<com.kdn.domain.model.response.GAuthLoginResponseModel>> getGAuthLoginRequest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.kdn.stack_knowledge_android.utils.Event> getSaveTokenRequest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.kdn.stack_knowledge_android.utils.Event<kotlin.Unit>> getSaveAuthorityResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.kdn.stack_knowledge_android.utils.Event<java.lang.String>> getGetAuthorityResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job gAuthLogin(@org.jetbrains.annotations.NotNull
    java.lang.String code) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveTheLoginData(@org.jetbrains.annotations.NotNull
    com.kdn.domain.model.response.GAuthLoginResponseModel data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getAuthorityInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteToken() {
        return null;
    }
}