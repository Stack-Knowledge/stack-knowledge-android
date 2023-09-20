package com.kdn.stack_knowledge_android.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/kdn/stack_knowledge_android/ui/login/LoginActivity;", "Lcom/kdn/stack_knowledge_android/ui/base/BaseActivity;", "Lcom/kdn/stack_knowledge_android/databinding/ActivityLoginBinding;", "()V", "authViewModel", "Lcom/kdn/stack_knowledge_android/viewmodel/AuthViewModel;", "getAuthViewModel", "()Lcom/kdn/stack_knowledge_android/viewmodel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "backButtonWait", "", "createView", "", "observeEvent", "observeLoginEvent", "onBackPressed", "pageController", "setGAuthButtonComponent", "setGAuthWebViewComponent", "OnBackPressedListener", "presentation_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class LoginActivity extends com.kdn.stack_knowledge_android.ui.base.BaseActivity<com.kdn.stack_knowledge_android.databinding.ActivityLoginBinding> {
    private final kotlin.Lazy authViewModel$delegate = null;
    private long backButtonWait = 0L;
    
    public LoginActivity() {
        super(0);
    }
    
    private final com.kdn.stack_knowledge_android.viewmodel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void createView() {
    }
    
    @java.lang.Override
    public void observeEvent() {
    }
    
    private final void setGAuthButtonComponent() {
    }
    
    private final void setGAuthWebViewComponent() {
    }
    
    private final void observeLoginEvent() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void pageController() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/kdn/stack_knowledge_android/ui/login/LoginActivity$OnBackPressedListener;", "", "onBackPressed", "", "presentation_debug"})
    public static abstract interface OnBackPressedListener {
        
        public abstract void onBackPressed();
    }
}