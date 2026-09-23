package com.coldfriesinoctober.walrus.music;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$fetchAccountName$2", f = "YtMusicApi.kt", i = {0, 0}, l = {485, 487}, m = "invokeSuspend", n = {"$this$withContext", "c"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class YtMusicApi$fetchAccountName$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Map<String, String> $cookies;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$fetchAccountName$2(Map<String, String> map, Continuation<? super YtMusicApi$fetchAccountName$2> continuation) {
        super(2, continuation);
        this.$cookies = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$fetchAccountName$2 ytMusicApi$fetchAccountName$2 = new YtMusicApi$fetchAccountName$2(this.$cookies, continuation);
        ytMusicApi$fetchAccountName$2.L$0 = obj;
        return ytMusicApi$fetchAccountName$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((YtMusicApi$fetchAccountName$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x011a, code lost:
    
        r0 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE.obj(r0, "accountName");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0124, code lost:
    
        r0 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE.array(r0, "runs");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0138, code lost:
    
        r0 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE.asObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0140, code lost:
    
        r0 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE.string(r0, "text");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0174, code lost:
    
        r1 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE.obj(r4, "accountPhoto");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00de  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$fetchAccountName$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
