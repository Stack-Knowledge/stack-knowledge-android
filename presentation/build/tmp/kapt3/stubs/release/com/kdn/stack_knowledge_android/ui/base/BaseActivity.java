package com.kdn.stack_knowledge_android.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J\b\u0010\u0012\u001a\u00020\u000eH&J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004R\u001c\u0010\u0007\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/kdn/stack_knowledge_android/ui/base/BaseActivity;", "B", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "layoutId", "", "(I)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "createView", "", "longToast", "kdn", "", "observeEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "shortToast", "presentation_release"})
public abstract class BaseActivity<B extends androidx.databinding.ViewDataBinding> extends androidx.appcompat.app.AppCompatActivity {
    private final int layoutId = 0;
    protected B binding;
    
    public BaseActivity(@androidx.annotation.LayoutRes
    int layoutId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    protected final B getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull
    B p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract void createView();
    
    public abstract void observeEvent();
    
    protected final void shortToast(@org.jetbrains.annotations.NotNull
    java.lang.String kdn) {
    }
    
    protected final void longToast(@org.jetbrains.annotations.NotNull
    java.lang.String kdn) {
    }
}