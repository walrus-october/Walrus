package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi", f = "YtMusicApi.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {362, 370}, m = "post", n = {"request", "last", "maxAttempts", "attempt", "request", "last", "maxAttempts"}, s = {"L$0", "L$1", "I$0", "I$2", "L$0", "L$1", "I$0"})
/* loaded from: classes5.dex */
public final class YtMusicApi$post$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ YtMusicApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$post$1(YtMusicApi ytMusicApi, Continuation<? super YtMusicApi$post$1> continuation) {
        super(continuation);
        this.this$0 = ytMusicApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object post;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        post = this.this$0.post(null, null, null, null, null, null, null, null, 0, false, null, this);
        return post;
    }
}
