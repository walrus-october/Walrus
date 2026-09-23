package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStream$2$raced$1", f = "YtMusicApi.kt", i = {0, 0}, l = {1200}, m = "invokeSuspend", n = {"deferreds", "winner"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
final class YtMusicApi$resolveStream$2$raced$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtStream>, Object> {
    final /* synthetic */ Ref.ObjectRef<Exception> $lastError;
    final /* synthetic */ String $videoId;
    final /* synthetic */ String $visitorData;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveStream$2$raced$1(String str, String str2, Ref.ObjectRef<Exception> objectRef, Continuation<? super YtMusicApi$resolveStream$2$raced$1> continuation) {
        super(2, continuation);
        this.$videoId = str;
        this.$visitorData = str2;
        this.$lastError = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$resolveStream$2$raced$1 ytMusicApi$resolveStream$2$raced$1 = new YtMusicApi$resolveStream$2$raced$1(this.$videoId, this.$visitorData, this.$lastError, continuation);
        ytMusicApi$resolveStream$2$raced$1.L$0 = obj;
        return ytMusicApi$resolveStream$2$raced$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtStream> continuation) {
        return ((YtMusicApi$resolveStream$2$raced$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012f A[LOOP:1: B:24:0x0129->B:26:0x012f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x010d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00f9 -> B:7:0x00fb). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStream$2$raced$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
