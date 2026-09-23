package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi", f = "YtMusicApi.kt", i = {0, 0, 0, 0}, l = {870, 905}, m = "resolveWithClient", n = {"this", "client", "visitorData", "probe"}, s = {"L$0", "L$1", "L$2", "Z$0"})
/* loaded from: classes5.dex */
public final class YtMusicApi$resolveWithClient$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ YtMusicApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveWithClient$1(YtMusicApi ytMusicApi, Continuation<? super YtMusicApi$resolveWithClient$1> continuation) {
        super(continuation);
        this.this$0 = ytMusicApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object resolveWithClient;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolveWithClient = this.this$0.resolveWithClient(null, null, null, false, this);
        return resolveWithClient;
    }
}
