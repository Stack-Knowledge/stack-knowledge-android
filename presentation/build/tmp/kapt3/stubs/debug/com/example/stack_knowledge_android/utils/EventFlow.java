package com.example.stack_knowledge_android.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0003*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/EventFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Companion", "presentation_debug"})
public abstract interface EventFlow<T extends java.lang.Object> extends kotlinx.coroutines.flow.Flow<T> {
    @org.jetbrains.annotations.NotNull
    public static final com.example.stack_knowledge_android.utils.EventFlow.Companion Companion = null;
    public static final int DEFAULT_REPLAY = 3;
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/stack_knowledge_android/utils/EventFlow$Companion;", "", "()V", "DEFAULT_REPLAY", "", "presentation_debug"})
    public static final class Companion {
        public static final int DEFAULT_REPLAY = 3;
        
        private Companion() {
            super();
        }
    }
}