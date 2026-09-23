package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Spotify.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.Spotify", f = "Spotify.kt", i = {0}, l = {185, 186}, m = "apiGetStatus", n = {"path"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class Spotify$apiGetStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Spotify this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spotify$apiGetStatus$1(Spotify spotify, Continuation<? super Spotify$apiGetStatus$1> continuation) {
        super(continuation);
        this.this$0 = spotify;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object apiGetStatus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        apiGetStatus = this.this$0.apiGetStatus(null, this);
        return apiGetStatus;
    }
}
