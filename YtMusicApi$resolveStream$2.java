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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStream$2", f = "YtMusicApi.kt", i = {0, 1, 1, 2, 2}, l = {775, 778, 806}, m = "invokeSuspend", n = {"now", "lastError", "now", "lastError", "now"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes5.dex */
public final class YtMusicApi$resolveStream$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtStream>, Object> {
    final /* synthetic */ String $videoId;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveStream$2(String str, Continuation<? super YtMusicApi$resolveStream$2> continuation) {
        super(2, continuation);
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$resolveStream$2 ytMusicApi$resolveStream$2 = new YtMusicApi$resolveStream$2(this.$videoId, continuation);
        ytMusicApi$resolveStream$2.L$0 = obj;
        return ytMusicApi$resolveStream$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtStream> continuation) {
        return ((YtMusicApi$resolveStream$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v28, types: [T, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.Exception] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStream$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
