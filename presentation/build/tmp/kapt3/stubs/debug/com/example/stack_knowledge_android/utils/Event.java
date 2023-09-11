package com.example.stack_knowledge_android.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\r\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0013\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\r\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\u00a8\u0006\""}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event;", "T", "", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "BadRequest", "Conflict", "ForBidden", "Loading", "ManyRequest", "NotAcceptable", "NotFound", "Server", "Success", "TimeOut", "TokenExpired", "UnKnown", "Unauthorized", "Lcom/example/stack_knowledge_android/utils/Event$BadRequest;", "Lcom/example/stack_knowledge_android/utils/Event$Conflict;", "Lcom/example/stack_knowledge_android/utils/Event$ForBidden;", "Lcom/example/stack_knowledge_android/utils/Event$Loading;", "Lcom/example/stack_knowledge_android/utils/Event$ManyRequest;", "Lcom/example/stack_knowledge_android/utils/Event$NotAcceptable;", "Lcom/example/stack_knowledge_android/utils/Event$NotFound;", "Lcom/example/stack_knowledge_android/utils/Event$Server;", "Lcom/example/stack_knowledge_android/utils/Event$Success;", "Lcom/example/stack_knowledge_android/utils/Event$TimeOut;", "Lcom/example/stack_knowledge_android/utils/Event$TokenExpired;", "Lcom/example/stack_knowledge_android/utils/Event$UnKnown;", "Lcom/example/stack_knowledge_android/utils/Event$Unauthorized;", "presentation_debug"})
public abstract class Event<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable
    private final T data = null;
    
    private Event(T data) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final T getData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$Loading;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class Loading extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.Loading INSTANCE = null;
        
        private Loading() {
            super(null);
        }
    }
    
    /**
     * 성공
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$Success;", "T", "Lcom/example/stack_knowledge_android/utils/Event;", "data", "(Ljava/lang/Object;)V", "presentation_debug"})
    public static final class Success<T extends java.lang.Object> extends com.example.stack_knowledge_android.utils.Event<T> {
        
        public Success() {
            super(null);
        }
        
        public Success(@org.jetbrains.annotations.Nullable
        T data) {
            super(null);
        }
    }
    
    /**
     * 400번 요청이 올바르지 않은 경우
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$BadRequest;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class BadRequest extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.BadRequest INSTANCE = null;
        
        private BadRequest() {
            super(null);
        }
    }
    
    /**
     * 401번 비인증 요청
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$Unauthorized;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class Unauthorized extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.Unauthorized INSTANCE = null;
        
        private Unauthorized() {
            super(null);
        }
    }
    
    /**
     * 403번 권한이 없음
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$ForBidden;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class ForBidden extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.ForBidden INSTANCE = null;
        
        private ForBidden() {
            super(null);
        }
    }
    
    /**
     * 404 찾을 수 없는 경우
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$NotFound;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class NotFound extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.NotFound INSTANCE = null;
        
        private NotFound() {
            super(null);
        }
    }
    
    /**
     * 406 맞는 규격이 없는 경우
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$NotAcceptable;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class NotAcceptable extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.NotAcceptable INSTANCE = null;
        
        private NotAcceptable() {
            super(null);
        }
    }
    
    /**
     * 408 요청이 너무 오래 걸리는 경우
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$TimeOut;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class TimeOut extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.TimeOut INSTANCE = null;
        
        private TimeOut() {
            super(null);
        }
    }
    
    /**
     * 409 권한이 없을 때
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$Conflict;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class Conflict extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.Conflict INSTANCE = null;
        
        private Conflict() {
            super(null);
        }
    }
    
    /**
     * 429 요청이 너무 많은 경우
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$ManyRequest;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class ManyRequest extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.ManyRequest INSTANCE = null;
        
        private ManyRequest() {
            super(null);
        }
    }
    
    /**
     * 50X 서버에러
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$Server;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class Server extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.Server INSTANCE = null;
        
        private Server() {
            super(null);
        }
    }
    
    /**
     * 예상치 못한 에러
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$UnKnown;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class UnKnown extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.UnKnown INSTANCE = null;
        
        private UnKnown() {
            super(null);
        }
    }
    
    /**
     * 토큰 만료 에러
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/stack_knowledge_android/utils/Event$TokenExpired;", "Lcom/example/stack_knowledge_android/utils/Event;", "", "()V", "presentation_debug"})
    public static final class TokenExpired extends com.example.stack_knowledge_android.utils.Event {
        @org.jetbrains.annotations.NotNull
        public static final com.example.stack_knowledge_android.utils.Event.TokenExpired INSTANCE = null;
        
        private TokenExpired() {
            super(null);
        }
    }
}