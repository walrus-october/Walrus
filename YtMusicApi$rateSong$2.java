package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$rateSong$2", f = "YtMusicApi.kt", i = {0}, l = {148, 149}, m = "invokeSuspend", n = {"cookies"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class YtMusicApi$rateSong$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $account;
    final /* synthetic */ boolean $like;
    final /* synthetic */ String $videoId;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$rateSong$2(int i, boolean z, String str, Continuation<? super YtMusicApi$rateSong$2> continuation) {
        super(2, continuation);
        this.$account = i;
        this.$like = z;
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$rateSong$2 ytMusicApi$rateSong$2 = new YtMusicApi$rateSong$2(this.$account, this.$like, this.$videoId, continuation);
        ytMusicApi$rateSong$2.L$0 = obj;
        return ytMusicApi$rateSong$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((YtMusicApi$rateSong$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0009. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$rateSong$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
