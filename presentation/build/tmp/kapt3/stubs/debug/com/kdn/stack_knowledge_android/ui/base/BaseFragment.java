package com.kdn.stack_knowledge_android.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0004J\b\u0010\u0017\u001a\u00020\u0013H&J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0004R\u0011\u0010\u0007\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/kdn/stack_knowledge_android/ui/base/BaseFragment;", "B", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/Fragment;", "layoutRes", "", "(I)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "mBinding", "Landroidx/databinding/ViewDataBinding;", "savedInstanceState", "Landroid/os/Bundle;", "getSavedInstanceState", "()Landroid/os/Bundle;", "setSavedInstanceState", "(Landroid/os/Bundle;)V", "createView", "", "longToast", "kdn", "", "observeEvent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "shortToast", "presentation_debug"})
public abstract class BaseFragment<B extends androidx.databinding.ViewDataBinding> extends androidx.fragment.app.Fragment {
    private final int layoutRes = 0;
    private B mBinding;
    @org.jetbrains.annotations.Nullable
    private android.os.Bundle savedInstanceState;
    
    public BaseFragment(@androidx.annotation.LayoutRes
    int layoutRes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final B getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.os.Bundle getSavedInstanceState() {
        return null;
    }
    
    public final void setSavedInstanceState(@org.jetbrains.annotations.Nullable
    android.os.Bundle p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
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