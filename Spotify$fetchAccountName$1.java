package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Spotify.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.Spotify", f = "Spotify.kt", i = {}, l = {209}, m = "fetchAccountName", n = {}, s = {})
/* loaded from: classes5.dex */
public final class Spotify$fetchAccountName$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Spotify this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spotify$fetchAccountName$1(Spotify spotify, Continuation<? super Spotify$fetchAccountName$1> continuation) {
        super(continuation);
        this.this$0 = spotify;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAccountName(this);
    }
}
