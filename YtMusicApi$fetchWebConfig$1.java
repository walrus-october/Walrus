package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi", f = "YtMusicApi.kt", i = {0}, l = {303}, m = "fetchWebConfig", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class YtMusicApi$fetchWebConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ YtMusicApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$fetchWebConfig$1(YtMusicApi ytMusicApi, Continuation<? super YtMusicApi$fetchWebConfig$1> continuation) {
        super(continuation);
        this.this$0 = ytMusicApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchWebConfig;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchWebConfig = this.this$0.fetchWebConfig(this);
        return fetchWebConfig;
    }
}
