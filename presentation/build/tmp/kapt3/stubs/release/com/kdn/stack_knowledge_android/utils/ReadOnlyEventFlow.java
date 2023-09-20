package com.kdn.stack_knowledge_android.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/kdn/stack_knowledge_android/utils/ReadOnlyEventFlow;", "T", "Lcom/kdn/stack_knowledge_android/utils/EventFlow;", "flow", "(Lcom/kdn/stack_knowledge_android/utils/EventFlow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentation_release"})
final class ReadOnlyEventFlow<T extends java.lang.Object> implements com.kdn.stack_knowledge_android.utils.EventFlow<T> {
    
    public ReadOnlyEventFlow(@org.jetbrains.annotations.NotNull
    com.kdn.stack_knowledge_android.utils.EventFlow<? extends T> flow) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.FlowCollector<? super T> collector, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
}