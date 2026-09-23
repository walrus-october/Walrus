package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Spotify.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.Spotify", f = "Spotify.kt", i = {0, 0, 0, 0}, l = {278}, m = "searchTrack", n = {"this", "title", "artist", "durationMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* loaded from: classes5.dex */
public final class Spotify$searchTrack$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Spotify this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spotify$searchTrack$1(Spotify spotify, Continuation<? super Spotify$searchTrack$1> continuation) {
        super(continuation);
        this.this$0 = spotify;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.searchTrack(null, null, 0L, this);
    }
}
